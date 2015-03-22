package simulator.analysis.formal;

import simulator.analysis.IProperty;
import simulator.analysis.PropertyBearerWrapper;
import simulator.util.Assert;


/**
 * A predicate that is true if, and only if, a specified property is true.
 * @author  Paulo Salem
 */
public class BooleanPropertyPredicate extends Predicate {

  /**
   * The boolean property.
   */
  private IProperty p;
  
  /**
   * The property's target.
   */
  private PropertyBearerWrapper pbw;
  
  
  public BooleanPropertyPredicate(IProperty p, PropertyBearerWrapper pbw){
    Assert.notNull(p);
    Assert.notNull(pbw);
    
    this.p = p;
    this.pbw = pbw;
  }
  
  @Override
  public boolean isTrue() {
    boolean b = false;
    
    try{
      b = Boolean.parseBoolean(p.getValueAsString(pbw));
    }
    catch(Exception e){
      b = false;
    }
    
    return b;
  }

}
