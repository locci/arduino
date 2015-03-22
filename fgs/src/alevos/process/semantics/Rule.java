package alevos.process.semantics;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Set;

import alevos.IllegalSemanticsException;
import alevos.expression.Expression;
import alevos.ts.Event;
import alevos.util.Pair;

/**
 * An abstract operational semantics rule.
 * 
 * @author Paulo Salem
 *
 */
public abstract class Rule {

  
  /**
   * Calculates the successors of the specified expression according to this rule.
   * 
   * @return A collection of pairs, in which each pair contains a successor expression
   *         and the event that leads to it.
   * @throws IllegalSemanticsException TODO
   */
  public abstract Collection<Pair<Event, Expression>> succ(Expression exp) throws IllegalSemanticsException;
  
  

  
  
  
  
  

  // TODO remove below??
  
  /**
   * Finds the events enabled in the specified expression.
   * 
   * @param exp The expression whose events are desired.
   * @return The events that can be performed at the specified state according to this rule.
   */
//  public abstract Set<Event> enabled(Expression exp);
  
  
  /**
   * Calculates the resulting expressions from the emission of the
   * specified event by the specified expression.
   * 
   * @param e The event to be emited. It must be enabled on the specified expression.
   * @param exp The expression to emit the event.
   * @return A set of the resulting expressions.
   */
//  public abstract Set<Expression> emit(Event e, Expression exp);
  
}
