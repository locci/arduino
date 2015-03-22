package simulator.engine.strategy;

import simulator.analysis.UndefinedPropertyException;
import simulator.components.ComponentInstantiationException;
import simulator.engine.SimulationState;
import simulator.engine.runner.SimulationRunException;
import simulator.util.Assert;



/**
 * A simple simulation strategy. It just runs the model and present
 * the final result.
 * 
 * @author  Paulo Salem
 */
public class StandardSimulation extends SimulationStrategy{

  /**
   * The maximum number of simulation runs to be executed.
   */
  protected int runs = 1;
  
  
  /**
   * The maximum number of iterations per simulation run.
   */
  protected int iterationsPerRun = 10;
  
  /**
   * Builds a new instance.
   * 
   * @param runs The maximum number of simulation runs to be executed.
   * @param iterationsPerRun The maximum number of iterations per simulation run.
   */
  public StandardSimulation(int runs, int iterationsPerRun) {
    super();
    Assert.nonNegativeNonZero(runs);
    Assert.nonNegativeNonZero(iterationsPerRun);
    
    this.name = "Standard Simulation";
    this.runs = runs;
    this.iterationsPerRun = iterationsPerRun;
    

  }
  
  @Override
  public void execute() throws ComponentInstantiationException, UndefinedPropertyException, SimulationRunException{
    
    for(int i = 0; i < runs; i++){
      runner.runSteps(iterationsPerRun);
    }
    

    
  }

@Override
  public String toString() {
    String s = "Standard simulation strategy                           \n";
    s = s +    "====================================================== \n";
    s = s + runner.getCurrentState().toString() + "\n";
    
    return s;
  }
  
  
  /**
   * 
   * @return The last simulation state.
   */
  public SimulationState getLastState(){
    return runner.getCurrentState();
  }

  
}
