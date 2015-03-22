package simulator.environment.esl;

import alevos.IllegalSemanticsException;
import alevos.expression.picalculus.PiName;
import alevos.expression.picalculus.PiOutputAction;
import alevos.expression.picalculus.PiPrefix;
import alevos.expression.picalculus.PiProcess;

public class Create extends ESLOperation {
  
  AgentProfile agent1;
  
  Action action;
  
  Stimulus stimulus;
  
  AgentProfile agent2;
  
  

  public Create(AgentProfile agent1, Action action, Stimulus stimulus,
      AgentProfile agent2) {
    super();
    this.agent1 = agent1;
    this.action = action;
    this.stimulus = stimulus;
    this.agent2 = agent2;
  }



  @Override
  public PiProcess toPiProcess(Context context) throws IllegalSemanticsException {
    
    //
    // Define and decorate PiNames
    //
    
    PiName ccn = new PiName(NAME_CREATE);

    PiName emi = new PiName(NAME_EMIT);
    emi.setDecorator("agentId", agent1.getIdentifier());
    emi.setDecorator("action", action.toEnvironmentAction());
    
    PiName sto = new PiName(NAME_STOP);
    sto.setDecorator("agentId", agent1.getIdentifier());
    sto.setDecorator("action",action.toEnvironmentAction());

    
    PiName beg = new PiName(NAME_BEGINNING);
    beg.setDecorator("agentId", agent2.getIdentifier());
    beg.setDecorator("stimulus", stimulus.toEnvironmentStimulus());
    
    PiName sta = new PiName(NAME_STABLE);
    sta.setDecorator("agentId", agent2.getIdentifier());
    sta.setDecorator("stimulus", stimulus.toEnvironmentStimulus());
    
    PiName end = new PiName(NAME_ENDING);
    end.setDecorator("agentId", agent2.getIdentifier());
    end.setDecorator("stimulus", stimulus.toEnvironmentStimulus());
    
    PiName abs = new PiName(NAME_ABSENT);
    abs.setDecorator("agentId", agent2.getIdentifier());
    abs.setDecorator("stimulus", stimulus.toEnvironmentStimulus());
    
    
    PiName destroy = new PiName(NAME_DESTROY);
    destroy.setDecorator("agentId1", agent1.getIdentifier());
    destroy.setDecorator("stimulus", stimulus.toEnvironmentStimulus());
    destroy.setDecorator("action", action.toEnvironmentAction());
    destroy.setDecorator("agentId2", agent2.getIdentifier());
    
    PiName done = new PiName(NAME_DONE);
    
    PiName x = new PiName("x"); // Some dummy parameter name

    PiOutputAction aCcn = new PiOutputAction(ccn, emi, sto, abs, beg, sta, end, destroy);
    PiOutputAction aDone = new PiOutputAction(done, x);
    
    return new PiPrefix(aCcn, aDone);
  }

}
