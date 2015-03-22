package simulator.environment;

public class InvalidEnvironmentException extends Exception {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public InvalidEnvironmentException() {
    super();
  }

  public InvalidEnvironmentException(String message, Throwable cause) {
    super(message, cause);
  }

  public InvalidEnvironmentException(String message) {
    super(message);
  }

  public InvalidEnvironmentException(Throwable cause) {
    super(cause);
  }

}
