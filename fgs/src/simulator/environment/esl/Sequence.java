package simulator.environment.esl;

import java.util.LinkedList;
import java.util.List;

import alevos.IllegalSemanticsException;
import alevos.expression.picalculus.PiProcess;

public class Sequence extends ESLOperator {
  
  ESLOperation operation;
  
  int n;
  

  public Sequence(ESLOperation operation, int n) {
    super();
    this.operation = operation;
    this.n = n;
  }


  @Override
  public PiProcess toPiProcess(Context context) throws IllegalSemanticsException {
    
    List<ESLOperation> ops = new LinkedList<ESLOperation>();
    
    for(int i = 0; i < n; i++){
      ops.add(operation);
    }
    
    SequentialComposition sc = new SequentialComposition(ops);
    
    return sc.toPiProcess(context);
  }

}
