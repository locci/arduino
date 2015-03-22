package simulator.environment.esl;

import alevos.IllegalSemanticsException;
import alevos.expression.picalculus.PiInputAction;
import alevos.expression.picalculus.PiName;
import alevos.expression.picalculus.PiProcess;

public class EnvironmentResponse extends ESLOperation {
  
  Action action;
  
  AgentProfile agent;
  
  ESLOperation operation;
  
  

  public EnvironmentResponse(Action action, AgentProfile agent,
      ESLOperation operation) {
    super();
    this.action = action;
    this.agent = agent;
    this.operation = operation;
  }



  @Override
  public PiProcess toPiProcess(Context context) throws IllegalSemanticsException {
    
    PiName emit = new PiName(NAME_EMIT);
    emit.setDecorator("agentId", agent.getIdentifier());
    emit.setDecorator("action", action.toEnvironmentAction());
    
    PiName stop = new PiName(NAME_STOP);
    stop.setDecorator("agentId", agent.getIdentifier());
    stop.setDecorator("action", action.toEnvironmentAction());
    
    
    PiName x = new PiName("x"); // A dummy parameter name
    
    PiInputAction aEmit = new PiInputAction(emit, x);
    PiInputAction aStop = new PiInputAction(stop, x);
    

    // We shall build something like this:
    //
    //      Forever(emit action ; operation; stop action)
    
    PiActionPrefixOperation emitOp = new PiActionPrefixOperation(aEmit);
    PiActionPrefixOperation stopOp = new PiActionPrefixOperation(aStop);
    SequentialComposition sc = new SequentialComposition(emitOp, operation, stopOp);
    UnboundedSequence er = new UnboundedSequence(sc);
    
    return er.toPiProcess(context);
  }

}
