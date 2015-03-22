package simulator.environment.esl;

import alevos.IllegalSemanticsException;
import alevos.expression.picalculus.PiName;
import alevos.expression.picalculus.PiOutputAction;
import alevos.expression.picalculus.PiPrefix;
import alevos.expression.picalculus.PiProcess;

public class BeginStimulation extends ESLOperation {
  
  Stimulus stimulus;
  
  AgentProfile agent;
  
  

  public BeginStimulation(Stimulus stimulus, AgentProfile agent) {
    super();
    this.stimulus = stimulus;
    this.agent = agent;
  }



  @Override
  public PiProcess toPiProcess(Context context) throws IllegalSemanticsException {
    
    PiName beginning = new PiName(NAME_BEGINNING);
    beginning.setDecorator("agentId", agent.getIdentifier());
    beginning.setDecorator("stimulus", stimulus.toEnvironmentStimulus());
    
    PiName stable = new PiName(NAME_STABLE);
    stable.setDecorator("agentId", agent.getIdentifier());
    stable.setDecorator("stimulus", stimulus.toEnvironmentStimulus());
    
    PiName done = new PiName(NAME_DONE);
    
    PiName x = new PiName("x"); // A dummy parameter name
    
    PiOutputAction aBeginning = new PiOutputAction(beginning, x);
    PiOutputAction aStable = new PiOutputAction(stable, x);
    PiOutputAction aDone = new PiOutputAction(done, x);
    
    return new PiPrefix(aBeginning, aStable, aDone);
  }

}
