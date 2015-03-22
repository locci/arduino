package simulator.environment.esl;

import java.util.List;

import alevos.IllegalSemanticsException;
import alevos.expression.picalculus.PiProcess;

public class ESLSpecification extends ESLExpression {
  
  List<Assignment> assignments;
   
  Environment environment;
  
  public ESLSpecification(List<Assignment> assignments, Environment environment) {
    super();
    this.assignments = assignments;
    this.environment = environment;
  }



  @Override
  public PiProcess toPiProcess(Context context) throws IllegalSemanticsException {
    // TODO Auto-generated method stub
    return null;
  }

}
