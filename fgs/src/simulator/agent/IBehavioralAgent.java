package simulator.agent;

import java.util.Collection;

import simulator.agent.action.EnvironmentAction;
import simulator.agent.stimuli.EnvironmentStimulus;

/**
 * An interface particular to agents following the Behavioral Agent Architecture.
 * 
 * @author Paulo Salem
 *
 */
public interface IBehavioralAgent extends IAgent{
  
  public enum StimulationStatus {BEGINNING, ENDING, STABLE, ABSENT}
  
  public enum ActionStatus {EMITTING, NOT_EMITTING}

  /**
   * Sets the current status of a stimulus.
   * 
   * @param environmentStimulus
   * @param status
   */
  public void receiveStimulus(EnvironmentStimulus environmentStimulus, StimulationStatus status);

  
  /**
   * Each agent has a set of possible stimuli that it may receive. This
   * method returns this set.
   * 
   * @return The stimuli that the agent may receive.
   */
  public Collection<EnvironmentStimulus> possibleStimuli();
  
  
  /**
   * 
   * @param action An action which this agent is capable of performing.
   * 
   * @return The current status of the specified action.
   */
  public ActionStatus getActionStatus(EnvironmentAction action);
  
  
  /**
   * Each agent has a set of possible actions that it may perform. This
   * method returns this set.
   * 
   * @return The possible actions of this agent.
   */
  public Collection<EnvironmentAction> possibleActions();
  
}
