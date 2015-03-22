package alevos.simulation;

/**
 * Indicates that an invalid request was made to the simulator.
 * 
 * @author Paulo Salem
 *
 */
public class InvalidSimulatorRequest extends Exception {

  public InvalidSimulatorRequest() {
    super();
   }

  public InvalidSimulatorRequest(String message, Throwable cause) {
    super(message, cause);
  }

  public InvalidSimulatorRequest(String message) {
    super(message);
  }

  public InvalidSimulatorRequest(Throwable cause) {
    super(cause);
  }

}
