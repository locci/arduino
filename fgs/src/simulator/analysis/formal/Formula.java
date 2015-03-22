package simulator.analysis.formal;

import simulator.analysis.UndefinedPropertyException;

/**
 * An abstract logical formula whose truth-value is assigned according
 * to the current simulation state. Concrete implementations
 * must define their own rules to truth-value assignment.
 * 
 * @author Paulo Salem
 */
public abstract class Formula {

  /**
   * Checks if the formula is true under the current state of affairs.
   * 
   * @return <code>true</code> if the formula is currently true;
   *         <code>false</code> otherwise.
   */
  public abstract boolean isTrue() throws UndefinedPropertyException;
  
  // TODO 
}
