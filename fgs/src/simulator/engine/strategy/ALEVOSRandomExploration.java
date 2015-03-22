package simulator.engine.strategy;

import simulator.analysis.UndefinedPropertyException;
import simulator.components.ComponentInstantiationException;
import simulator.engine.runner.SimulationRunException;
import simulator.environment.IALEVOSEnvironment;
import simulator.environment.IEnvironment;
import simulator.environment.InvalidEnvironmentException;
import simulator.util.Assert;
import alevos.IllegalSemanticsException;
import alevos.exploration.RandomWalkExploration;
import alevos.simulation.InvalidSimulatorRequest;
import alevos.simulation.SimulatorConnector;
import alevos.ts.AnnotatedTransitionSystem;

public class ALEVOSRandomExploration extends ALEVOSSimulationStrategy {

  /**
   * The maximum number of simulation runs to be executed.
   */
  protected int runs = 1;
  
  
  /**
   * The maximum number of iterations per simulation run.
   */
  protected int iterationsPerRun = 100;
  
  
  /**
   * Exploration algorithm.
   */
  protected RandomWalkExploration rwe;
  
  /**
   * Builds a new instance.
   * 
   * @param runs The maximum number of simulation runs to be executed.
   * @param iterationsPerRun The maximum number of iterations per simulation run.
   */
  public ALEVOSRandomExploration(int runs, int iterationsPerRun, String group) {
    super(group);
    Assert.nonNegativeNonZero(runs);
    Assert.nonNegativeNonZero(iterationsPerRun);
    
    this.name = "ALEVOS Random Exploration";
    this.runs = runs;
    this.iterationsPerRun = iterationsPerRun;
    this.rwe = new RandomWalkExploration(runs, iterationsPerRun);
  }
  
  
  @Override
  public void execute() throws ComponentInstantiationException,
      UndefinedPropertyException, InvalidEnvironmentException,
      SimulationRunException {
    
    IEnvironment environment = this.runner.getInitialEnvironment();
    AnnotatedTransitionSystem ats = ((IALEVOSEnvironment) environment).getATS();
    
    try {
      rwe.explore(ats, simulatorConnector);
      
    } catch (IllegalSemanticsException e) {
      
      throw new SimulationRunException("The semantics expected from a transition system was violated.", e);
    
    } catch (InvalidSimulatorRequest e) {
      
      throw new SimulationRunException("ALEVOS made an invalid request to the simulator.", e);
    }

  }

  @Override
  public String toString() {
    String s = "Random Exploration strategy                     \n";
    s = s +    "====================================================== \n";
    s = s +    "Running time = " + this.runningTime() / 1000000000 + "s";
    
    return s;
  }

}
