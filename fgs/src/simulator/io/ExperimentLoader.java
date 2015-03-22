package simulator.io;

import java.io.File;

import simulator.Experiment;
import simulator.environment.IEnvironment;
import simulator.util.Assert;

public abstract class ExperimentLoader {
  
  /**
   * The environment in which the experiment will be performed.
   */
  protected IEnvironment environment;

  public ExperimentLoader(IEnvironment environment){
	System.out.println("ExperimentLoader passei aqui******************************");
    Assert.notNull(environment);
    
    this.environment = environment;
  }
  
  public abstract Experiment loadExperiment(File f) throws ExperimentLoadingException;
}
