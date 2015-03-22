package simulator.analysis;

/**
 * Indicates that a property is being used in a way it is not intended
 * to. For example, a property desigened to operate over whole enviornments
 * should not be used to analyze individual agents, a situation that
 * would raise this exception.
 * 
 * @author Paulo Salem
 *
 */
public class UndefinedPropertyException extends Exception {

  public UndefinedPropertyException(String message){
    super(message);
  }
  public UndefinedPropertyException(String message, Throwable cause){
    super(message, cause);
  }
}
