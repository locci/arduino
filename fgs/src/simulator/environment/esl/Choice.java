package simulator.environment.esl;

import java.util.LinkedList;
import java.util.List;

import alevos.IllegalSemanticsException;
import alevos.expression.picalculus.PiChoice;
import alevos.expression.picalculus.PiProcess;

public class Choice extends ESLOperator {
  
  List<ESLOperation> operations;

  
  
  public Choice(List<ESLOperation> operations) {
    super();
    this.operations = operations;
  }



  @Override
  public PiProcess toPiProcess(Context context) throws IllegalSemanticsException {
    
    List<PiProcess> piOps = new LinkedList<PiProcess>();
    
    for(ESLOperation op: operations){
      piOps.add(op.toPiProcess(context));
    }

    return new PiChoice(piOps);
  }
  


}
