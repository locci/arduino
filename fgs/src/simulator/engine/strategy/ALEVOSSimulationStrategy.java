package simulator.engine.strategy;

import alevos.simulation.SimulatorConnector;
import simulator.analysis.UndefinedPropertyException;
import simulator.components.ComponentInstantiationException;
import simulator.engine.runner.SimulationRunException;
import simulator.environment.InvalidEnvironmentException;

public abstract class ALEVOSSimulationStrategy extends SimulationStrategy {
  
  /**
   * A mechanism to allow the ALEVOS library to access the guide simulator.
   */
  protected SimulatorConnector simulatorConnector;

  public void setSimulatorConnector(SimulatorConnector simulatorConnector) {
    this.simulatorConnector = simulatorConnector;
  }
  
  public ALEVOSSimulationStrategy(String group){
    super(group);
  }
  
  



}
