package simulator.environment.esl;

import alevos.IllegalSemanticsException;
import alevos.expression.picalculus.PiProcess;

public class Assignment extends ESLExpression {
  
  String variableName;
  
  ESLExpression value;

  
  
  public Assignment(String variableName, ESLExpression value) {
    super();
    this.variableName = variableName;
    this.value = value;
  }



  @Override
  public PiProcess toPiProcess(Context context) throws IllegalSemanticsException {
    // TODO Auto-generated method stub
    return null;
  }

}
