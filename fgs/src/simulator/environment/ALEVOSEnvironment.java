package simulator.environment;

import simulator.Scenario;
import simulator.engine.runner.ExecutionMode;
import simulator.util.Assert;
import alevos.ts.AnnotatedTransitionSystem;

/**
 * An abstract implementation for any environment that uses ALEVOS as an exogenous coordination
 * mechanism.
 * 
 * @author Paulo Salem
 *
 */
public abstract class ALEVOSEnvironment extends AbstractEnvironment implements IALEVOSEnvironment {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  /**
   * The transition system that defines the environment behavior.
   */
  protected transient AnnotatedTransitionSystem ats; // TODO transient ??
  
  public ALEVOSEnvironment(Scenario scenario, AnnotatedTransitionSystem ats) {
    super(scenario);
    Assert.notNull(ats);
    this.ats = ats;
  }

  @Override
  public void step(ExecutionMode mode) {
    if(mode.equals(ExecutionMode.EXPLORATION)){
      explorationStep();
    }
    else if(mode.equals(ExecutionMode.VERIFICATION)){
      verificationStep();
    }
    else{
      throw new IllegalArgumentException("The requested execution mode is invalid.");
    }
    
  }
  
  protected abstract void verificationStep();
  
  protected abstract void explorationStep();

  /////////////////////////////////////////////////////////////////////////////
  // IALEVOSEnvironment methods
  /////////////////////////////////////////////////////////////////////////////

  @Override
  public AnnotatedTransitionSystem getATS() {
    return ats;
  }



  

}
