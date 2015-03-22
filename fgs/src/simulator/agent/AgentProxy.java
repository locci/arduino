package simulator.agent;

import java.io.Serializable;
import java.util.Collection;

import simulator.agent.action.EnvironmentAction;
import simulator.agent.stimuli.EnvironmentStimulus;
import simulator.util.Assert;

/**
 * A proxy that controls access to a particular agent.
 * @author   Paulo Salem
 */
public class AgentProxy implements IAgent, IBehavioralAgent, Serializable{
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  
  /**
   * The actual agent that this proxy represents.
   */
  private IAgent agent = null;
  


  
  public AgentProxy(IAgent agent){
    Assert.notNull(agent);
    
    this.agent = agent;    
  }
  
  /////////////////////////////////////////////////////////////////////////////
  // IAgent methods
  /////////////////////////////////////////////////////////////////////////////
  
  public int getId() {
    return agent.getId();
  }

  public String getName() {
    return agent.getName();
  }

  public void receiveStimulus(EnvironmentStimulus environmentStimulus){
    agent.receiveStimulus(environmentStimulus);
  }

  
  /////////////////////////////////////////////////////////////////////////////
  // Proxy management methods
  /////////////////////////////////////////////////////////////////////////////
  
  /**
   * @return The actual agent, without the proxy.
   */
  public IAgent getAgent(){
    return agent;
  }

  /**
   * Sets a the new agent that this proxy must refer to.
   * 
   * @param agent The actual agent.
   */
  public void setAgent(IAgent agent){
    Assert.notNull(agent);
    
    this.agent = agent; 
  }

  

  
  
  /////////////////////////////////////////////////////////////////////////////
  // Comparison methods
  /////////////////////////////////////////////////////////////////////////////
  
  public boolean equals(Object o){
    return agent.equals(o);
  }

  public int hashCode(){
    return agent.hashCode();
  }

  /////////////////////////////////////////////////////////////////////////////
  // IBehavioralAgent methods
  /////////////////////////////////////////////////////////////////////////////
  
  @Override
  public void receiveStimulus(EnvironmentStimulus environmentStimulus,
      StimulationStatus status) {
    
      ((IBehavioralAgent) agent).receiveStimulus(environmentStimulus, status);
    
  }

  @Override
  public Collection<EnvironmentStimulus> possibleStimuli() {
    return ((IBehavioralAgent) agent).possibleStimuli();
  }

  @Override
  public ActionStatus getActionStatus(EnvironmentAction action) {
    return ((IBehavioralAgent) agent).getActionStatus(action);
  }

  @Override
  public Collection<EnvironmentAction> possibleActions() {
    return ((IBehavioralAgent) agent).possibleActions();
  }
  

}
