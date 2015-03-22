package simulator.environment.esl;

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

public class Parallel extends ESLOperator {
  
  List<ESLOperation> operations;

  
  
  public Parallel(List<ESLOperation> operations) {
    super();
    this.operations = operations;
  }



  @Override
  public PiProcess toPiProcess(Context context) throws IllegalSemanticsException {
    
    PiName done = new PiName("done");
    PiName start = new PiName("start");

    PiName x = new PiName("x"); // Some dummy parameter
    
    PiOutputAction aDone = new PiOutputAction(done, x);
    PiInputAction aStart = new PiInputAction(start, x);
    
    
    
    
    // The operations put in parallel
    PiProcess par = buildPart(operations, context);
    
    // The final component
    PiPrefix fin = new PiPrefix(aDone, new PiNilProcess());
    for(int i = 0; i < operations.size(); i++){
      fin = new PiPrefix(aStart, fin);
    }
    
    // Put the final component in the parallel composition
    par = new PiParallel(par, fin);
    
    // Add the restriction and we are done
    PiProcess res = new PiRestriction(start, par);
        
    return res;
  }
  
  private PiProcess buildPart(List<ESLOperation> ops, Context context) throws IllegalSemanticsException{

    PiName done = new PiName("done");
    PiName start = new PiName("start");

    if(ops.size() == 0){
      return new PiNilProcess();
    }
    else if(ops.size() == 1){
      PiProcess p = ops.get(0).toPiProcess(context);
      p.substitute(done, start);
      return p;
    }
    else{
      
      PiProcess op1 = ops.get(0).toPiProcess(context);
      op1.substitute(done, start);
      
       
      PiParallel par = new PiParallel(
                                op1, 
                                buildPart(ops.subList(1,ops.size()), context));
    
      return par;
    }
    
  }

}
