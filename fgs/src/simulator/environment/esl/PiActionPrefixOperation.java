package simulator.environment.esl;

import alevos.IllegalSemanticsException;
import alevos.expression.picalculus.PiActionPrefix;
import alevos.expression.picalculus.PiName;
import alevos.expression.picalculus.PiOutputAction;
import alevos.expression.picalculus.PiPrefix;
import alevos.expression.picalculus.PiProcess;

/**
 * A class to encapsulate PiProcess that are operations.
 * 
 * @author Paulo Salem
 *
 */
public class PiActionPrefixOperation extends ESLOperation {
  
  protected PiActionPrefix prefix = null;
  
  public PiActionPrefixOperation(PiActionPrefix prefix){
    this.prefix = prefix;
  }

  @Override
  public PiProcess toPiProcess(Context context) throws IllegalSemanticsException {
    
    // We shall merely append an output done event to the
    // given action prefix, thus creating an operation.
    
    PiName done = new PiName(NAME_DONE);
    
    PiName x = new PiName("x"); // Some dummy parameter name
    
    PiOutputAction aDone = new PiOutputAction(done, x);
    
    PiPrefix proc = new PiPrefix(prefix, aDone);
    
    return proc;
  }

}
