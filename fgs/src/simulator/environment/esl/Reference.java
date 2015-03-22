package simulator.environment.esl;

import alevos.IllegalSemanticsException;
import alevos.expression.picalculus.PiProcess;

public class Reference extends ESLExpression {
  
  String variableName;
  
  

  public Reference(String variableName) {
    super();
    this.variableName = variableName;
  }



  @Override
  public PiProcess toPiProcess(Context context) throws IllegalSemanticsException {
    // TODO Auto-generated method stub
    return null;
  }

}
