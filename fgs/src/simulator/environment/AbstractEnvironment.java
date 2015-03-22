package simulator.environment;

import java.io.Serializable;
import java.util.List;

import simulator.Scenario;
import simulator.agent.IAgent;
import simulator.engine.SimulationState;
import simulator.util.Assert;

/**
 * Implements the most general methods from the <code>IEnvironment</code> interface.
 * 
 * @author Paulo Salem
 *
 */
public abstract class AbstractEnvironment implements IEnvironment, Serializable {
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  /**
   * The scenario that defines which elements shall be present in the simulation.
   */
  protected Scenario scenario = null;
  
  /**
   * The simulation state that this environment gives access to.
   */
  protected SimulationState currentState = null;
  // TODO update currentState during the simulation...

  
  public AbstractEnvironment(Scenario scenario){
    Assert.notNull(scenario);
    
    this.scenario = scenario;
  }

  /////////////////////////////////////////////////////////////////////////////
  // IEnvironment methods
  /////////////////////////////////////////////////////////////////////////////

  @Override
  public List<IAgent> getAgents(){
    return scenario.getAgentProxies(); 
  }
  
  @Override
  public IAgent getAgent(int id){
    
    for(IAgent a: scenario.getAgentProxies()){
      if(a.getId() == id){
        return a;
      }
    }
    
    return null;
  }

  @Override
  public void setSimulationState(SimulationState state){
      Assert.notNull(state);
      
      this.currentState = state;   
  }

}
