package alevos.ts.sp;

/**
 * A singleton Failure.
 * 
 * @author Paulo Salem
 *
 */
public class FailureState extends VerdictState {

  private static FailureState instance = null;
  
  private FailureState(){
    
  }
  
  public static FailureState instance(){
    if(instance == null){
      instance = new FailureState();
      instance.setName("failure");
    }
    
    return instance;
  }
  
  @Override
  public String toString() {
    
    return "Failure";
  }
  


}
