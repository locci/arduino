package alevos.ts.sp;


/**
 * A singleton Success.
 * 
 * @author Paulo Salem
 *
 */
public class SuccessState extends VerdictState {

  private static SuccessState instance = null;
  
  private SuccessState(){
    
  }
  
  public static SuccessState instance(){
    if(instance == null){
      instance = new SuccessState();
      instance.setName("success");
    }
    
    return instance;
  }
  
  @Override
  public String toString() {
    
    return "Success";
  }

}
