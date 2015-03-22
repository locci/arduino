package simulator.environment.esl;

import alevos.IllegalSemanticsException;
import alevos.expression.picalculus.PiName;
import alevos.expression.picalculus.PiNilProcess;
import alevos.expression.picalculus.PiOutputAction;
import alevos.expression.picalculus.PiPrefix;
import alevos.expression.picalculus.PiProcess;

/**
 * An operation that effectively does nothing ("no op").
 * 
 * @author Paulo Salem
 *
 */
public class Nop extends ESLOperation {

  @Override
  public PiProcess toPiProcess(Context context) throws IllegalSemanticsException {
    
    PiName done = new PiName(NAME_DONE);
    
    PiName x = new PiName("x"); // Some dummy parameter name
    
    PiOutputAction aDone = new PiOutputAction(done, x);
    
    return new PiPrefix(new PiNilProcess(), aDone);
  }

}
