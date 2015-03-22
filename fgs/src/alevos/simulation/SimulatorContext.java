package alevos.simulation;

import java.util.Set;

import alevos.ts.Literal;

/**
 * Each simulation state might provide contextual information useful for exploration and verification
 * which is not available directly on the formal transition systems.
 * This class must be extended in order to implement contexts appropriate to the
 * simulation platform.
 * 
 * 
 * @author Paulo Salem
 *
 */
public abstract class SimulatorContext {

  // TODO
  /**
   * Retrieves the literals that are true in this context.
   * 
   * @return A collection of literals.
   */
  public abstract Set<Literal> getLiterals();
}
