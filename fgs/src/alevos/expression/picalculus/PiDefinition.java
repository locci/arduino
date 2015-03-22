package alevos.expression.picalculus;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import alevos.expression.Definition;
import alevos.expression.Expression;

public class PiDefinition extends Definition {

  protected List<PiName> parameters = new LinkedList<PiName>();
  
  public PiDefinition(String name, List<PiName> parameters, Expression expression) {
    super(name, expression);
    this.parameters = parameters;
  }
  
  

  
  public List<PiName> getParameters() {
    return parameters;
  }




  @Override
  public String toString() {
    String s = name + "(";
    
    Iterator<PiName> it = parameters.iterator();
    while(it.hasNext()){
      s = s + it.next().toString();
      
      if(it.hasNext()){
        s = s + ", ";
      }
    }
    
    s = s + ") = " + this.expression.toString();
    
    return s;
  }
  
}
