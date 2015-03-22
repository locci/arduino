package simulator.agent.action;

import java.io.Serializable;

import simulator.util.Assert;

/**
 * Represents the action of an agent as it is transmitted through an environment. 
 * Objects from this class are immutable in order to facilitate
 * sharing.
 * 
 * @author Paulo Salem
 *
 */
public class EnvironmentAction implements Serializable{
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  
  private String type;

  public EnvironmentAction(String type) {
    super();
    
    Assert.notNull(type);
    
    this.type = type;
  }
  
  
  @Override
  public String toString(){
    return "[Action type='"+ type +"']";
  }
  
  
  
  public String getType() {
    return type;
  }


  @Override
  public boolean equals(Object obj){
    
    if(obj instanceof EnvironmentAction){
      EnvironmentAction a = (EnvironmentAction) obj;
      if(this.type.equals(a.type)){
        return true;
      }
    }
    
    return false;
  }
  
  @Override
  public int hashCode(){
    return type.hashCode();
  }

}
