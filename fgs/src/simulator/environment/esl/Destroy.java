package simulator.environment.esl;

import alevos.IllegalSemanticsException;
import alevos.expression.picalculus.PiName;
import alevos.expression.picalculus.PiOutputAction;
import alevos.expression.picalculus.PiPrefix;
import alevos.expression.picalculus.PiProcess;

public class Destroy extends ESLOperation {
  
  AgentProfile agent1;
  
  Stimulus stimulus;
  
  Action action;
  
  AgentProfile agent2;
  
  

  public Destroy(AgentProfile agent1, Action action, Stimulus stimulus,
      AgentProfile agent2) {
    super();
    this.agent1 = agent1;
    this.stimulus = stimulus;
    this.action = action;
    this.agent2 = agent2;
  }



  @Override
  public PiProcess toPiProcess(Context context) throws IllegalSemanticsException {
    
    PiName destroy = new PiName(NAME_DESTROY);
    destroy.setDecorator("agentId1", agent1.getIdentifier());
    destroy.setDecorator("stimulus", stimulus.toEnvironmentStimulus());
    destroy.setDecorator("action", action.toEnvironmentAction());
    destroy.setDecorator("agentId2", agent2.getIdentifier());
    
    PiName done = new PiName(NAME_DONE);
    
    PiName x = new PiName("x");
    
    PiOutputAction aDestroy = new PiOutputAction(destroy, x);
    PiOutputAction aDone = new PiOutputAction(done, x);
    
    return new PiPrefix(aDestroy, aDone);
  }

}
