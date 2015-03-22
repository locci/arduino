package simulator.engine.alevos;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import simulator.agent.IBehavioralAgent.ActionStatus;
import simulator.agent.IBehavioralAgent.StimulationStatus;
import simulator.agent.action.EnvironmentAction;
import simulator.agent.stimuli.EnvironmentStimulus;
import simulator.analysis.IBooleanProperty;
import simulator.analysis.IProperty;
import simulator.analysis.PropertyBearerWrapper;
import simulator.analysis.UndefinedPropertyException;
import simulator.engine.SimulationState;
import simulator.environment.EMMASEnvironment;
import simulator.ui.Messenger;
import simulator.ui.SimulatorUI;
import alevos.simulation.SimulatorContext;
import alevos.ts.Literal;

public class EMMASSimulatorContext extends SimulatorContext {

  private EMMASEnvironment environment = null;
  
  private SimulationState currentSimState = null;
  
  public EMMASSimulatorContext(EMMASEnvironment environment, SimulationState currentSimState) {
    super();
    this.environment = environment;
    this.currentSimState = currentSimState;
  }

  // TODO put the pi-process here somewhere?
  public StimulationStatus stimulation(Integer agentId, EnvironmentStimulus stimulus){
    // TODO calculate here
    return null;
  }
  
  public ActionStatus response(Integer agentId, EnvironmentAction action){
    return environment.getActionStatus(agentId, action);
  }

  @Override
  public Set<Literal> getLiterals() {
    Set<Literal> literals = new HashSet<Literal>();
    
    for(PropertyBearerWrapper pbw: currentSimState.getPropertyBearerWrappers()){

      String msg = "Properties (for  " + pbw.getName() + "): ";
      for(IProperty p: pbw.getProperties()){

        // Only propositions concern us here
        if(p instanceof IBooleanProperty){
          IBooleanProperty bp = (IBooleanProperty)p;
          
          Literal l = null;
          if(bp.isTrue(pbw)){
            l = new Literal(p.getName(), Literal.Type.POSITIVE);
          }
          else{
            l = new Literal(p.getName(), Literal.Type.NEGATIVE);
          }
          
          literals.add(l);
          
          
          try {
            msg = msg + " [" + p.getName() + " = " + p.getValueAsString(pbw) + "]";
          } catch (UndefinedPropertyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
  
        }
      }
      
      SimulatorUI.instance().getMessenger().printDebugMsg(msg, Messenger.IMPORTANT_MSG);
    }

    return literals;
  }
  
  
  
}
