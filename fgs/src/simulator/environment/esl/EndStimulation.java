package simulator.environment.esl;

import alevos.IllegalSemanticsException;
import alevos.expression.picalculus.PiName;
import alevos.expression.picalculus.PiOutputAction;
import alevos.expression.picalculus.PiPrefix;
import alevos.expression.picalculus.PiProcess;

public class EndStimulation extends ESLOperation {

  Stimulus stimulus;
  
  AgentProfile agent;
  
  

  public EndStimulation(Stimulus stimulus, AgentProfile agent) {
    super();
    this.stimulus = stimulus;
    this.agent = agent;
  }
  
  
  @Override
  public PiProcess toPiProcess(Context context) throws IllegalSemanticsException {
    
    PiName ending = new PiName(NAME_ENDING);
    ending.setDecorator("agentId", agent.getIdentifier());
    ending.setDecorator("stimulus", stimulus.toEnvironmentStimulus());
    
    PiName absent = new PiName(NAME_ABSENT);
    absent.setDecorator("agentId", agent.getIdentifier());
    absent.setDecorator("stimulus", stimulus.toEnvironmentStimulus());
    
    PiName done = new PiName(NAME_DONE);
    
    PiName x = new PiName("x");
    
    PiOutputAction aEnding = new PiOutputAction(ending, x);
    PiOutputAction aAbsent = new PiOutputAction(absent, x);
    PiOutputAction aDone = new PiOutputAction(done, x);
    
    return new PiPrefix(aEnding, aAbsent, aDone);
  }

}
