package simulator.environment;

import alevos.ts.AnnotatedTransitionSystem;

/**
 * An ALEVOS environment should provide an exogenous coordination mechanism defined by
 * a transition system.
 * 
 * @author Paulo Salem
 *
 */
public interface IALEVOSEnvironment extends IEnvironment{
  
  public AnnotatedTransitionSystem getATS();
  

}
