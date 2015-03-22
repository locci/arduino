package simulator.environment.esl;

import java.util.LinkedList;

import alevos.IllegalSemanticsException;
import alevos.expression.picalculus.PiDefinition;
import alevos.expression.picalculus.PiIdentifier;
import alevos.expression.picalculus.PiInputAction;
import alevos.expression.picalculus.PiName;
import alevos.expression.picalculus.PiOutputAction;
import alevos.expression.picalculus.PiParallel;
import alevos.expression.picalculus.PiPrefix;
import alevos.expression.picalculus.PiProcess;
import alevos.expression.picalculus.PiRestriction;

public class UnboundedSequence extends ESLOperator {
  
  ESLOperation operation;

  public UnboundedSequence(ESLOperation operation) {
    super();
    this.operation = operation;
  }

  @Override
  public PiProcess toPiProcess(Context context) throws IllegalSemanticsException {

    PiName start = new PiName("start");
    PiName done = new PiName("done");
    
    PiName x = new PiName("x"); // Some dummy parameter
    
    PiInputAction aStart = new PiInputAction(start, x);
    
    PiProcess op1 = operation.toPiProcess(context);
    op1.substitute(done, start);
    
    PiIdentifier forever = new PiIdentifier("Forever");
    
    PiProcess seq = new PiRestriction(
        start, 
        new PiParallel(
            op1, 
            new PiPrefix(
                aStart, 
                forever)));
    
    PiDefinition foreverDef = new  PiDefinition(forever.getName(), new LinkedList<PiName>(), seq);
    forever.setDefinition(foreverDef);
    
    return seq;
  }

}
