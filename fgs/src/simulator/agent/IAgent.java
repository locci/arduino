package simulator.agent;

import simulator.agent.stimuli.EnvironmentStimulus;


/**
 * Represents an agent within the simulation.
 * 
 * @author Paulo Salem
 *
 */
public interface IAgent {
  
  /**
   * @return The agent's unique ID number.
   */
  public int getId();

  /**
   * @return The agent's name.
   */
  public String getName();


  /**
   * Handles the specified stimulus.
   * 
   * @param environmentStimulus The stimulus to be handled by the agent.
   */
  public void receiveStimulus(EnvironmentStimulus environmentStimulus);

  
}
