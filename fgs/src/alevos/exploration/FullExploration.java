package alevos.exploration;

import alevos.IllegalSemanticsException;
import alevos.simulation.InvalidSimulatorRequest;
import alevos.simulation.SimulatorConnector;
import alevos.ts.AnnotatedTransitionSystem;

/**
 * Explores the whole state-space up to the specified depth.
 * 
 * @author Paulo Salem
 *
 */
public class FullExploration extends ExplorationAlgorithm {
  
  // TODO integrate this explorarion in the system
  
  
  
  
  protected int runs = 1;
  
  private int maxDepth = 2;
  
  public FullExploration(int runs, int maxDepth) {
    this.runs = runs;
    this.maxDepth = maxDepth;
  }

  @Override
  public void explore(AnnotatedTransitionSystem ts, SimulatorConnector sc)
      throws IllegalSemanticsException, InvalidSimulatorRequest {
    
    // Prepare the simulator
    sc.setup();
    
    sc.printDebugMsg("Initial state = " + ts.getInitialState().toString() + "\n\n", SimulatorConnector.IMPORTANT_MSG);

    for(int i = 0; i < runs; i++){
      
      
      
      // TODO
      
      
      
      
      
    }
    

  }

}
