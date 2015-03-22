package simulator.engine;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

import alevos.simulation.InvalidSimulatorRequest;

import simulator.Scenario;
import simulator.analysis.UndefinedPropertyException;
import simulator.components.ComponentInstantiationException;
import simulator.components.ComponentsRegistry;
import simulator.components.NoSuchStateInspectorException;
import simulator.engine.alevos.EMMASSimulatorConnector;
import simulator.engine.runner.SimulationRunException;
import simulator.engine.runner.SimulationRunner;
import simulator.engine.strategy.ALEVOSSimulationStrategy;
import simulator.engine.strategy.SimulationStrategy;
import simulator.environment.InvalidEnvironmentException;
import simulator.io.ScenarioLoadingException;
import simulator.ui.Messenger;
import simulator.ui.SimulatorUI;
import simulator.visualization.StateVisualizer;


/**
 * Manages the execution of the simulation experiment.
 * 
 * @author     Paulo Salem
 */
public class SimulationEngine {
  
  // TODO Idea: there could be one SimulationRunner for each SimulationStrategy, and all of them
  //            could run in parallel.
  
  private SimulationRunner runner;
  
  private Collection<SimulationStrategy> strategies = new LinkedList<SimulationStrategy>();
  
  private Scenario scenario = null;
  
  private ComponentsRegistry registry = null;
  
  
  /**
   * Creates a new <code>SimulationEngine</code>.
   * 
   * @param scenario The simulation scenario to be executed.
   * 
   * @param strategy The simulation strategy to be employed.
   * @throws ComponentInstantiationException If there are problems while building the initial state.
 * @throws InvalidSimulatorRequest 
 * @throws ClassNotFoundException 
 * @throws IOException 
 * @throws ScenarioLoadingException 
 * @throws NoSuchStateInspectorException 
   */
  public SimulationEngine(Scenario scenario, Collection<SimulationStrategy> strategies, ComponentsRegistry registry) throws Exception, ComponentInstantiationException, NoSuchStateInspectorException, ScenarioLoadingException, IOException, ClassNotFoundException, InvalidSimulatorRequest{

    // Check parameters
    if(scenario == null || strategies == null || registry == null){
      throw new IllegalArgumentException();
    }
    
    this.strategies = strategies;
    this.scenario = scenario;
    this.registry = registry;
    
    //try {
		runner = new SimulationRunner(scenario.createInitialState(registry));
	//} catch (Exception e) {
		// TODO Auto-generated catch block
	//	e.printStackTrace();
	//}
    
    // Setup strategies
    for(SimulationStrategy ss: strategies){
      
      // Connect the strategy to the appropriate simulation runner
      ss.setSimulationRunner(runner);
      
      // If it is an ALEVOS strategy, we shall also need a simulator connector
      if(ss instanceof ALEVOSSimulationStrategy){
        if(scenario.getEMMAS() != null){
          ((ALEVOSSimulationStrategy)ss).setSimulatorConnector(new EMMASSimulatorConnector(runner));
        }
        else{
          throw new IllegalArgumentException("Any ALEVOS simulation strategy must have an appropriate simulator connector.");
        }
      }
    }
  }
  
  /**
   * Runs the simulation. Each new call to this method shall
   * replace the results obtained with the previous one.
   * @throws SimulationRunException 
   * @throws InvalidEnvironmentException 
   */
  public void executeStrategies() throws ComponentInstantiationException, UndefinedPropertyException, InvalidEnvironmentException, SimulationRunException{
    
    // Run all the strategies
    for(SimulationStrategy ss: strategies){
      SimulatorUI.instance().getMessenger().printMsg("\nRunning the " + ss.getName() + " strategy...", Messenger.IMPORTANT_MSG);
      ss.startChronometer();
      ss.execute();
      ss.stopChronometer();
    }
    
  }
  
  /**
   * 
   * @return The current state of the simulation.
   */
  public SimulationState getCurrentState(){
    return runner.getCurrentState();
  }
  
/**
 * @return  The simulation scenario of the engine.
 */
  public Scenario getScenario(){
    return scenario;
  }
  
  /**
   * 
   * @return The components registry of the engine.
   */
  public ComponentsRegistry getComponentsRegistry(){
    return registry;
  }
  

}
