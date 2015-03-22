package alevos.expression;

import java.util.List;

import alevos.expression.picalculus.PiName;

public abstract class Definition {
  
  protected String name;
  
  protected Expression expression;
  
  /**
   * Whether this identifier is being unfolded. This information is used to 
   * prevent infinite unfoldings.
   */
  protected boolean isBeingUnfolded = false;
  

  public Definition(String name, Expression expression) {
    super();
    
    this.name = name;
    this.expression = expression;
    
  }
  
  public boolean isBeingUnfolded() {
    return isBeingUnfolded;
  }


  public void setBeingUnfolded(boolean isBeingUnfolded) {
    this.isBeingUnfolded = isBeingUnfolded;
  }
  
  public String toString(){
    return name + " = " + expression.toString();
  }


  public String getName() {
    return name;
  }
  
  

  public Expression getExpression() {
    return expression;
  }
  
  
  
  
}
