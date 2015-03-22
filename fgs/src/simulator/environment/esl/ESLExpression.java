package simulator.environment.esl;

import alevos.IllegalSemanticsException;
import alevos.expression.picalculus.PiProcess;

/**
 * An abstract Environment Specification Language experession.
 * 
 * @author Paulo Salem
 *
 */
public abstract class ESLExpression {
  
  //
  // Action emission pi-calculus names
  //
  public static final String NAME_EMIT = "emit";
  public static final String NAME_STOP = "stop";
  
  //
  // Stimulation pi-calculus names
  //
  public static final String NAME_BEGINNING = "beginning";
  public static final String NAME_STABLE = "stable";
  public static final String NAME_ENDING = "ending";
  public static final String NAME_ABSENT = "absent";
  
  public static final String NAME_CREATE = "ccn";
  public static final String NAME_DESTROY = "destroy";
  
  public static final String NAME_START = "start";
  public static final String NAME_DONE = "done";
  
  public static final String NAME_COMMIT = "commit";
  
  //
  // Markers
  //
  
  public static final String MARKER_AGENT = "agent";
  public static final String MARKER_ACTION_TRANSFORMER = "at";
  
  
  public abstract PiProcess toPiProcess(Context context) throws IllegalSemanticsException;

}
