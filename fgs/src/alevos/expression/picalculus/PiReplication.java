package alevos.expression.picalculus;

import java.util.Map;
import java.util.Set;

import alevos.IllegalSemanticsException;
import alevos.process.semantics.PiReplicationRule;

public class PiReplication extends PiUnaryProcess {

  
  public PiReplication(PiProcess proc) {
    super(proc);
    
    this.addApplicableRule(new PiReplicationRule());
  }

  @Override
  public Object clone() {
    PiReplication obj = new PiReplication((PiProcess)proc.clone());
    obj.setSuccessorsCached(copySuccessorsCache());
    return obj;
  }
  
  @Override
  public String toString() {
    return "!" + proc.toString();
  }

  @Override
  public boolean substitute(Map<PiName, PiName> substitution) throws IllegalSemanticsException {
    
    if(this.getProc().substitute(substitution)){
      clearCache();
      return true;
    }
    
    return false;
    
  }

  @Override
  public Set<PiName> boundNames() throws IllegalSemanticsException {
    return this.getProc().boundNames();
  }

  @Override
  public Set<PiName> freeNames() {
    return this.getProc().freeNames();
  }

  @Override
  public void alphaConversion() throws IllegalSemanticsException {
    this.proc.alphaConversion();
  }


}
