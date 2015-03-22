package alevos.expression.picalculus;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import alevos.IllegalSemanticsException;

public class PiNilProcess extends PiProcess {

  @Override
  public Object clone() {
    PiNilProcess clone = new PiNilProcess();
    clone.marker = this.marker;
    clone.incompatibleMarkers = (HashSet<String>) this.incompatibleMarkers.clone();
    
    return clone;
  }

  @Override
  public String toString() {
    
    return "0";
  }
  
  @Override
  public int size() {
    return 1; 
  }
  
  @Override
  public int cachedSuccessorsSize() {
    return 0;
  }

  @Override
  public boolean substitute(Map<PiName, PiName> substitution) throws IllegalSemanticsException {
    // Nothing to be done.
    return false;
    
  }

  @Override
  public Set<PiName> boundNames() throws IllegalSemanticsException {
    
    return new HashSet<PiName>();
  }

  @Override
  public Set<PiName> freeNames() {
    
    return new HashSet<PiName>();
  }

  @Override
  public void alphaConversion() throws IllegalSemanticsException {
    // nothing
    
  }



}
