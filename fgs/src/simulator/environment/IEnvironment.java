package simulator.environment;

import java.util.List;

import simulator.agent.IAgent;
import simulator.engine.SimulationState;
import simulator.engine.runner.ExecutionMode;

/**
 * An environment defines the elements that exist in a simulation and how they interact.
 * This interaction can be either endogenous or exogenous. In the endogenous case,
 * agents themselves choose how to communicate with other agents. In the exogenous case,
 * the environment chooses how agents shall communicate with each other.
 * 
 * @author Paulo Salem
 *
 */
public abstract interface IEnvironment {
  
  public void step(ExecutionMode mode);
  
  public List<IAgent> getAgents();

  public IAgent getAgent(int id);
  
  public void setSimulationState(SimulationState state);

}
