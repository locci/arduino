package alevos.verification;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import alevos.IllegalSemanticsException;
import alevos.simulation.InvalidSimulatorRequest;
import alevos.simulation.SimulatorConnector;
import alevos.ts.AnnotatedTransitionSystem;
import alevos.ts.Event;
import alevos.ts.IOEvent;
import alevos.ts.State;
import alevos.ts.sp.SimulationPurpose;
import alevos.ts.sp.SuccessState;
import alevos.util.Pair;

// TODO delete this class?
/**
 * @deprecated Use the new <code>VerifyFeasibility</code> class, which handles both strong and weak feasibility variants.
 * @author Paulo Salem
 *
 */
public class VerifyWeakFeasibility extends VerificationAlgorithm {
  
  
  public VerifyWeakFeasibility(int maxDepth, boolean randomize,
      Integer maxSynchSteps) {
    super(maxDepth, randomize, maxSynchSteps);
   
  }

  @Override
  public Verdict verify(SimulationPurpose sp, AnnotatedTransitionSystem ts, SimulatorConnector sc) throws IllegalSemanticsException, InvalidSimulatorRequest {
    
    // Make the simulator available to the transition system, so that the contextual restrictions
    // may be applied
    ts.setSimulatorConnector(sc);
    
    // Preprocess the simulation purpose
    preprocess(sp, SuccessState.instance());
    
    int succsCounter = 0; // TODO A counter of how many environment states have been considered. For debugging...
    int synchCounter = 0; // TODO A counter of how many synchronizations happened. For debugging... 
    
    // How many steps in the synchronous transition system have been examined
    long steps = 0;
    
    // Depth in the search tree
    int depth = 0;
    
    //Stack<Sextuple<State, State, IOEvent, State, Object, TraceInfo>> synchStack = new Stack<Sextuple<State, State, IOEvent, State, Object, TraceInfo>>();
    Stack<SynchState> synchStack = new Stack<SynchState>();
    
    // Get the initial simulator state
    Object simInit = sc.currentState();                        // SIMULATION INTERFACE
    
    List<Pair<Event, State>> unexplored = new LinkedList<Pair<Event, State>>();
    unexplored.addAll(sp.succ(sp.getInitialState()));
    SynchState init = new SynchState(sp.getInitialState(), ts.getInitialState(), null, null, null, simInit, ts.getInitialTraceInfo(), unexplored, depth);
    
    synchStack.push(init);
    
    Verdict verdict = Verdict.FAILURE;
    
    while(!synchStack.empty()){
      SynchState current = synchStack.peek();
      
      State q = current.getStateSP();
      State s = current.getStateATS();
      Object currentSimState = current.getSimulationState();             // SIMULATION INTERFACE
      TraceInfo ti = current.getTraceInfo();
      unexplored = current.getUnexplored();
      depth = current.getDepth();
      
      boolean progress = false;
      
      //sc.printDebugMsg("(a) s size = " + s.getExpression().size(), SimulatorConnector.NORMAL_MSG);
      //sc.printDebugMsg("(a) s's cached successors size = " + s.getExpression().cachedSuccessorsSize(), SimulatorConnector.NORMAL_MSG);

      
      while(!unexplored.isEmpty() && progress == false && depth < maxDepth){
        Pair<Event, State> transQ = removeBest(q, unexplored);
        IOEvent f = (IOEvent) transQ.getFirst();
        State nextQ = transQ.getSecond();
        int nextDepth = depth + 1;
        
        
        succsCounter++;
        Collection<Pair<Event, State>> succs = ts.succ(s, ti);
        for(Pair<Event, State> transS: succs ){
          IOEvent g = (IOEvent) transS.getFirst();
          State nextS = transS.getSecond();
          
          // Return the simulation to the appropriate state
          sc.goToState(currentSimState);                        // SIMULATION INTERFACE
          
          sc.scheduleStep(g);                                  // SIMULATION INTERFACE
          
          // Inform the transition system that an event has been chosen
          TraceInfo nextTi = (TraceInfo)ti.clone();
          ts.eventScheduled(g, nextTi);
          
          if(sc.getCommitEvent().equals(g)){                   // SIMULATION INTERFACE
            sc.step();                                         // SIMULATION INTERFACE
          }
          
          if(canSynch(sp, q, f, nextQ, s, g, nextS, sc)){
            
           sc.printMsg("[depth = "+depth +"]" +" Events synch'ed: (" + f +",       " + g +"); " +
               "States annotations synch'ed: (" +nextQ.getLiterals() + ",       " + nextS.getLiterals() +"); "+
               " SP trans.: (" + q.getName() + " -> " + nextQ.getName() + ")", SimulatorConnector.NORMAL_MSG);// + "; " +
               //"  Environment = " + nextS.toString());

           sc.printDebugMsg("[synch. stack size = " + synchStack.size() + "] " +
                            "[synch's = "+synchCounter +"]", SimulatorConnector.NORMAL_MSG);
           
           //sc.printDebugMsg("(b) s size = " + s.getExpression().size(), SimulatorConnector.NORMAL_MSG);
           //sc.printDebugMsg("(b) s's cached successors size = " + s.getExpression().cachedSuccessorsSize(), SimulatorConnector.NORMAL_MSG);
           //sc.printDebugMsg("(b) nextS size = " + nextS.getExpression().size(), SimulatorConnector.NORMAL_MSG);
           //sc.printDebugMsg("(b) nextS's cached successors size = " + nextS.getExpression().cachedSuccessorsSize(), SimulatorConnector.NORMAL_MSG);

           //
           // Stack the synchronization
           //
           
           Object nextSimState = sc.currentState();         // SIMULATION INTERFACE
           
           List<Pair<Event, State>> nextUnexplored = new LinkedList<Pair<Event, State>>();
           nextUnexplored.addAll(sp.succ(nextQ));
           
           SynchState next = new SynchState(nextQ, nextS, f, g, q, nextSimState, nextTi,nextUnexplored, nextDepth);
           synchStack.push(next);
           
           
           progress = true;

           // Check whether we found what we wanted
            if(nextQ.equals(SuccessState.instance())){
              buildTrace(synchStack, nextQ, nextDepth); // builds the feasible trace
              return Verdict.SUCCESS;
            }
            
            // Cancel the search if there is a limit to the number of synchronizations allowed.
            synchCounter++;
            if(maxSynchSteps != null){
              if(synchCounter >= maxSynchSteps){
                sc.printMsg("WARNING: The search has been aborted because the maximum number of synchronizations allowed (" + maxSynchSteps + ") has been reached.", SimulatorConnector.IMPORTANT_MSG);
                buildTrace(synchStack, q, depth);
                return Verdict.INCONCLUSIVE;
              }
            }

          }
        }  

      }
      
      if(depth >= maxDepth){
        verdict = Verdict.INCONCLUSIVE;
        
        sc.printMsg("WARNING: Search depth limit (" + maxDepth + ") has been reached.", SimulatorConnector.IMPORTANT_MSG);
      }
      
      
      if(progress == false){
        synchStack.pop();
        
      }
      
    }
    
    return verdict;
    
  }
  
  

}
