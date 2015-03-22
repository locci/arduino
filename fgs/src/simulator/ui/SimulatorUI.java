package simulator.ui;

import simulator.util.Assert;

public class SimulatorUI {

  private static SimulatorUI instance;
  
  private Messenger messenger;
  
  private SimulatorUI(Messenger messenger){
    Assert.notNull(messenger);
    this.messenger = messenger;
  }
  
  public static void initialize(Messenger messenger){
    Assert.notNull(messenger);
    
    if(instance == null){
      instance = new SimulatorUI(messenger);
    }
    else{
      instance.messenger = messenger;
    }
    
  }
  
  
  public static SimulatorUI instance(){
    
    if(instance == null){
      throw new RuntimeException("Please initialize the SimulatorUI before using it.");
    }
    
    return instance;
  }

  public Messenger getMessenger() {
    return messenger;
  }
  
  
  
}
