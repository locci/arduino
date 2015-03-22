package simulator.engine.alevos;

import java.util.Collection;
import java.util.HashSet;

import simulator.agent.action.EnvironmentAction;
import simulator.agent.stimuli.EnvironmentStimulus;
import alevos.util.Pair;
import alevos.verification.TraceInfo;

public class EMMASTraceInfo extends TraceInfo {

  //
  // Safeguards used to implement the trace constraints
  //
  
  protected HashSet<Pair<Integer, EnvironmentStimulus>> stimulationSafeguard = new HashSet<Pair<Integer, EnvironmentStimulus>>();
  
  protected HashSet<Pair<Integer, EnvironmentAction>> actionSafeguard = new HashSet<Pair<Integer, EnvironmentAction>>();

  
  public EMMASTraceInfo() {
    super();
  }

  public EMMASTraceInfo(
      HashSet<Pair<Integer, EnvironmentStimulus>> stimulationSafeguard,
      HashSet<Pair<Integer, EnvironmentAction>> actionSafeguard) {
    super();
    this.stimulationSafeguard = stimulationSafeguard;
    this.actionSafeguard = actionSafeguard;
  }

  public void putStimulationSafeguard(Integer agentId, EnvironmentStimulus stimulus){
    Pair<Integer, EnvironmentStimulus> as = new Pair<Integer, EnvironmentStimulus>(agentId, stimulus);
    stimulationSafeguard.add(as);
  }
  
  public boolean hasStimulationSafeguard(Integer agentId, EnvironmentStimulus stimulus){
    Pair<Integer, EnvironmentStimulus> as = new Pair<Integer, EnvironmentStimulus>(agentId, stimulus);
    return stimulationSafeguard.contains(as);
  }
  
  public void clearStimulationSafeguards(){
    stimulationSafeguard.clear();
  }
  
  
  public void putActionSafeguard(Integer agentId, EnvironmentAction action){
    Pair<Integer, EnvironmentAction> aa = new Pair<Integer, EnvironmentAction>(agentId, action);
    actionSafeguard.add(aa);
  }
  
  public boolean hasActionSafeguard(Integer agentId, EnvironmentAction action){
    Pair<Integer, EnvironmentAction> aa = new Pair<Integer, EnvironmentAction>(agentId, action);
    return actionSafeguard.contains(aa);
  }
  
  public void clearActionSafeguard(){
    actionSafeguard.clear();
  }
  
  public Object clone(){
    return new EMMASTraceInfo((HashSet<Pair<Integer, EnvironmentStimulus>>)stimulationSafeguard.clone(), 
        (HashSet<Pair<Integer, EnvironmentAction>>)actionSafeguard.clone());
  }
}
