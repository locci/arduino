package alevos.expression.picalculus;

import java.util.HashSet;

import alevos.expression.Expression;
import alevos.ts.Event;
import alevos.util.Pair;

public abstract class PiUnaryProcess extends PiProcess {

  protected PiProcess proc;

  public PiProcess getProc() {
    return proc;
  }

  public PiUnaryProcess(PiProcess proc) {
    super();
    
    this.proc = proc;
    
    defineMarker(proc);
  }
  
  @Override
  public int size(){
    return 1 + proc.size();
  }
  
  @Override
  public int cachedSuccessorsSize() {
    int size = 1 + proc.cachedSuccessorsSize();
    
    return cachedSuccessorsSizeAux(size);
  }
   
}
