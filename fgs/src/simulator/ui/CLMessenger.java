package simulator.ui;

/**
 * Shows messages in the command line.
 * 
 * @author Paulo Salem
 *
 */
public class CLMessenger extends Messenger {

  public CLMessenger(){
    super();
  }
  
  public CLMessenger(int minMsgImportance, boolean showDebugMsgs) {
    super(minMsgImportance, showDebugMsgs);
  }

  @Override
  protected void printMsg(String msg) {
    System.out.println(msg);

  }

  @Override
  protected void printDebugMsg(String msg) {
    System.out.println("DEBUG INFO: " + msg);

  }

}
