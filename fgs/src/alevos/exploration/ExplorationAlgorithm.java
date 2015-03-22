package alevos.exploration;

import alevos.IllegalSemanticsException;
import alevos.simulation.InvalidSimulatorRequest;
import alevos.simulation.SimulatorConnector;
import alevos.ts.AnnotatedTransitionSystem;

/**
 * Exploration algorithms aim merely at visiting states and monitoring what happens, without
 * asserting or enforcing any particular goal. That is to say, they are not to be used
 * for verification. Possible uses of such exploration include the collection of
 * statistics for later analysis and the validation of simulation models.
 * 
 * @author Paulo Salem
 *
 */
public abstract class ExplorationAlgorithm {
  
  /**
   * Starts the exploration of the specified transition system using the specified
   * simulator connector.
   * 
   * @param ts The transition system to be explored.
   * @param sc The simulator connector to use.
   * @throws IllegalSemanticsException 
   * @throws InvalidSimulatorRequest 
   */
  public abstract void explore(AnnotatedTransitionSystem ts, SimulatorConnector sc) throws IllegalSemanticsException, InvalidSimulatorRequest;
  

}
