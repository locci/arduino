package alevos.verification;

/**
 * Holds useful information about the current trace being explored in the transition system.
 * This class is supposed to be subclassed in order to add the particular information
 * needed for applications (e.g., special trace constraints).
 * 
 * @author Paulo Salem
 *
 */
public class TraceInfo implements Cloneable{

  @Override
  public Object clone(){
    return new TraceInfo();
  }
}

