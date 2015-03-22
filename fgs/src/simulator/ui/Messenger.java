package simulator.ui;

import simulator.util.Assert;

/**
 * Allows information to be presented to the user. Concrete subclasses define the particular
 * method of presentation.
 * 
 * @author Paulo Salem
 *
 */
public abstract class Messenger {
  
  protected boolean showDebugMsgs = false;
  
  protected int minMsgImportance = NORMAL_MSG;
  
  public final static int TRIVIAL_MSG = 0;
  public final static int UNINPORTANT_MSG = 1;
  public final static int NORMAL_MSG = 2;
  public final static int IMPORTANT_MSG = 3;
  public final static int CRUCIAL_MSG = 4;
  
  
  public Messenger(){
   
  }
  
  public Messenger(int minMsgImportance, boolean showDebugMsgs){
    Assert.isInInterval(minMsgImportance, TRIVIAL_MSG, CRUCIAL_MSG);
    
    this.minMsgImportance = minMsgImportance;
    this.showDebugMsgs = showDebugMsgs;
  }
  
  
  public void printMsg(String msg, int msgImportance){
    Assert.isInInterval(msgImportance, TRIVIAL_MSG, CRUCIAL_MSG);
    
    if (msgImportance >= minMsgImportance){
      printMsg(msg);
    }
  }
  
  abstract protected void printMsg(String msg);
  
  
  public void printDebugMsg(String msg, int msgImportance){
    Assert.isInInterval(msgImportance, TRIVIAL_MSG, CRUCIAL_MSG);
    
    if(showDebugMsgs && msgImportance >= minMsgImportance){
      printDebugMsg(msg);
    }
  }
  
  abstract protected void printDebugMsg(String msg);


  public void setShowDebugMsgs(boolean showDebugMsgs) {
    this.showDebugMsgs = showDebugMsgs;
  }

  public void setMinMsgImportance(int minMsgImportance) {
    this.minMsgImportance = minMsgImportance;
  }

  
  
}
