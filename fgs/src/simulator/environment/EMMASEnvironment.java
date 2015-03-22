package simulator.environment;


import java.util.LinkedList;
import java.util.List;

import simulator.Scenario;
import simulator.agent.IBehavioralAgent;
import simulator.agent.IBehavioralAgent.ActionStatus;
import simulator.agent.IBehavioralAgent.StimulationStatus;
import simulator.agent.action.EnvironmentAction;
import simulator.agent.stimuli.EnvironmentStimulus;
import alevos.ts.AnnotatedTransitionSystem;
import alevos.util.Triple;

/**
 * An environment that employs the ALEVOS library as an exogenous coordinator to
 * implement an EMMAS environment.
 * 
 * @author Paulo Salem
 *
 */
public class EMMASEnvironment extends ALEVOSEnvironment {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  /**
   * Stores all the stimulation to deliver at the same time. Each triple
   * contains the target agent id, a stimulus, and its status. 
   */
  private List<Triple<Integer, EnvironmentStimulus, StimulationStatus>> stimulationBuffer = new LinkedList<Triple<Integer, EnvironmentStimulus, StimulationStatus>>();

  public EMMASEnvironment(Scenario scenario, AnnotatedTransitionSystem ats) {
    super(scenario, ats);
  }
  

  @Override
  protected void verificationStep(){
    update();
  }
  
  @Override
  protected void explorationStep(){
    // TODO choose a course of action in the ATS
    
    // TODO update whatever is relevant for the chosen path
    
    // Updates the state according to the chosen path
    update();
  }
  
  private void update(){

    // Deliver the stimulation that was buffered  
    for(Triple<Integer, EnvironmentStimulus, StimulationStatus> ies: stimulationBuffer){
      IBehavioralAgent agent = (IBehavioralAgent) getAgent(ies.getFirst());
      agent.receiveStimulus(ies.getSecond(),ies.getThird());
    }
    
    // Since all stimulation has been given, we may clear the buffer for the next round
    stimulationBuffer.clear();
  }

  
  public ActionStatus getActionStatus(Integer agentId, EnvironmentAction action){
    IBehavioralAgent agent = (IBehavioralAgent) getAgent(agentId);
    return agent.getActionStatus(action);
  }

  
   public void deliverStimulation(Integer agentId, EnvironmentStimulus stimulus, StimulationStatus status){
     
     // Put on a buffer. We shall deliver it in the next update cycle.
     stimulationBuffer.add(new Triple<Integer, EnvironmentStimulus, StimulationStatus>(agentId, stimulus, status));
   }


  
   
   
  
  
  // TODO remove? Maybe it can be useful in non-verification mode....
///**
// * Defines how actions should be transformed in ALEVOS events.
// * 
// * @param agentId The id of the concerned agent.
// * @param action The action to be converted into an event.
// * 
// * @return An event corresponding to the specified agent's action.
// */
//public EMMASEvent toEvent(int agentId, EnvironmentAction action){
//  
//  // Retrieves the action status for that agent
//  ActionStatus status = getActionStatus(agentId, action);
//  
//  // Based on the action status, come up with the appropriate event name
//  String name;
//  if(status.equals(ActionStatus.EMITTING)){
//    name = "Emit";
//  }
//  else{
//    name = "Stop";
//  }
//  
//  // TODO Build a new parametrized event.
//  
//  // TODO
//  return null;
//}
  

}
