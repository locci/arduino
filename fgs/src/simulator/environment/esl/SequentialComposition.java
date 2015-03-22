package simulator.environment.esl;

import java.util.LinkedList;
import java.util.List;

import alevos.IllegalSemanticsException;
import alevos.expression.picalculus.PiInputAction;
import alevos.expression.picalculus.PiName;
import alevos.expression.picalculus.PiNilProcess;
import alevos.expression.picalculus.PiOutputAction;
import alevos.expression.picalculus.PiParallel;
import alevos.expression.picalculus.PiPrefix;
import alevos.expression.picalculus.PiProcess;
import alevos.expression.picalculus.PiRestriction;

public class SequentialComposition extends ESLOperation {

  List<ESLOperation> operations;
  
  public SequentialComposition(ESLOperation... operations) {
    super();
    
    List<ESLOperation> opsList = new LinkedList<ESLOperation>();
    for(ESLOperation op: operations){
      opsList.add(op);
    }
    
    this.operations = opsList;
  }
  
  public SequentialComposition(List<ESLOperation> operations) {
    super();
    this.operations = operations;
  }

  @Override
  public PiProcess toPiProcess(Context context) throws IllegalSemanticsException {
    return build(operations, context);
  }
  
  private PiProcess build(List<ESLOperation> ops, Context context) throws IllegalSemanticsException{

    PiName done = new PiName("done");
    PiName x = new PiName("x"); // Some dummy parameter
    
    PiOutputAction aDone = new PiOutputAction(done, x);

    
    if(ops.size() == 0){
      return new PiPrefix(aDone, new PiNilProcess());
    }
    else if(ops.size() == 1){
      return ops.get(0).toPiProcess(context);
    }
    else{
      PiName start = new PiName("start");
      
      PiInputAction aStart = new PiInputAction(start, x);
      
      PiProcess op1 = ops.get(0).toPiProcess(context);
      op1.substitute(done, start);

      
      PiProcess seq = new PiRestriction(
                            start, 
                            new PiParallel(
                                op1, 
                                new PiPrefix(
                                    aStart, 
                                    build(ops.subList(1,ops.size()), context))));
    
      return seq;
    }
    
  }

}
