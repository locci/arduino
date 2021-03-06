package simulator.engine.strategy;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.HashSet;
import java.util.Set;

import simulator.analysis.UndefinedPropertyException;
import simulator.components.ComponentInstantiationException;
import simulator.engine.runner.SimulationRunException;
import simulator.engine.runner.SimulationRunner;
import simulator.environment.InvalidEnvironmentException;
import simulator.util.Assert;

/**
 * @author    Paulo Salem
 */
public abstract class SimulationStrategy {
  
  /**
   * The simulation runner being directed.
   */
  protected SimulationRunner runner = null;
  
  protected long startTime = 0;
  protected long terminationTime = 0;
  
  protected String name="Unnamed Strategy";
  
  /**
   * Identifies this strategy as part of a certain group.
   */
  protected String group = null;
  
 /**
  * The elements in this set denote groups of strategies that do not need to be performed
  * anymore. This is useful when many strategies are created in order to address
  * the same question, one of them suceeds in doing this, and therefore the
  * remaining ones are no longer necessary. Concrete strategies are responsible
  * for managing this.
  */
  protected static Set<String> finishedGroups = new HashSet<String>();
  

  public SimulationStrategy(){
    
  }
  
  public SimulationStrategy(String group){
    Assert.notNull(group);
    
    this.group = group;
  }
  
  protected boolean isGroupFinished(String group){
    if(finishedGroups.contains(group)){
      return true;
    }
    
    return false;
  }
  
  protected void addFinishedGroup(String group){
    finishedGroups.add(group);
  }
  

  
  public void startChronometer() throws SimulationRunException{
    ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
    if(bean.isCurrentThreadCpuTimeSupported()){
      startTime = bean.getCurrentThreadCpuTime(); 
    }
    else{
      throw new SimulationRunException("Cannot measure current thread CPU time.");
    }
  }
  
  public void stopChronometer() throws SimulationRunException{
    ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
    if(bean.isCurrentThreadCpuTimeSupported()){
      terminationTime = bean.getCurrentThreadCpuTime(); 
    }
    else{
      throw new SimulationRunException("Cannot measure current thread CPU time.");
    }
    
  }
  
  protected long runningTime(){
    return terminationTime - startTime;
  }
  
  
  /**
   * Executes the simulation strategy.
   * @throws InvalidEnvironmentException 
   * @throws SimulationRunException 
   * 
   */
  public abstract void execute() throws ComponentInstantiationException, UndefinedPropertyException, InvalidEnvironmentException, SimulationRunException;
  
  
  /**
   * Returns a textual description of the strategy status,
   * including its results. Concrete subclasses must overide
   * this method.  
   * 
   * @return The status of the strategy.
   */
  public abstract String toString();
 
  public String getName(){
    return name;
  }
  
  public void setSimulationRunner(SimulationRunner runner){
    this.runner = runner;
  }

 



}
