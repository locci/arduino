package alevos.ts.sp;

import alevos.ts.Event;
import alevos.ts.Literal;
import alevos.ts.State;

/**
 * An abstract verdict for verifications. Subclasses must be implemented using the singleton pattern,
 * since verdicts should contain no particular data.
 * 
 * @author Paulo Salem
 *
 */
public abstract class VerdictState extends State {
  
  public abstract String toString();
  
  @Override
  public void addStaticSuccessor(Event e, State s){
    // Does nothing, since a verdict is always terminal
  }
  
  @Override
  public void addLiteral(Literal p){
    // Does nothing, since a verdict contains no further information
  }

}
