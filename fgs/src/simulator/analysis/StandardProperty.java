package simulator.analysis;

import java.io.Serializable;

import simulator.components.AComponentInfo;
import simulator.environment.IEnvironment;

/**
 * @author  Paulo Salem
 */
@AComponentInfo(
  id = "simulator.analysis.StandardProperty",
  version = 1,
  name = "Standard Property",
  description = "A base and abstract implementation of a property.",
  type = AComponentInfo.ComponentType.PROPERTY
)
abstract public class StandardProperty implements IProperty, Serializable{
  
  private static final long serialVersionUID = 1L;
  

	
	/**
	 * The unique identificator of the property's instance.
	 */
	private int id;
  
	/**
	 * A user friendly name to the propertie's instance.
	 */
	private String name="(Unnamed property instance)";
	
  /**
   * The environment to be analyzed. Subclasses may access this directly.
   */
  protected IEnvironment environment;
	
	///////////////////////////////////////////////////////////////////////////
	// IProperty methods
	///////////////////////////////////////////////////////////////////////////
	
	
	/**
   * @return  the id
   */
	public int getId(){
		return id;
	}
	
	/**
   * @param id  the id to set
   */
	public void setId(int id){
		this.id = id;
	}
	
	/**
   * @return  the name
   */
	public String getName(){
		return name;
	}
	
	/**
   * @param name  the name to set
   */
	public void setName(String name){
		this.name = name;
	}
  
  public void setEnvironment(IEnvironment environment){
    this.environment = environment;
  }
	
	abstract public String getValueAsString(PropertyBearerWrapper pb) throws UndefinedPropertyException;
	
  abstract public String getValueAsString(Object o) throws UndefinedPropertyException;
	
	
	  /////////////////////////////////////////////////////////////////////////////
	  // Comparison methods
	  /////////////////////////////////////////////////////////////////////////////
	  
	  public boolean equals(Object o){
	    return equals((IProperty) o);
	  }

	  public int hashCode(){
	    return id;
	  }
	  
	  /**
	   * Two properties are equal iff their IDs are equal.
	   * 
	   * @param p The property to be compared to this one.
	   * 
	   * @return <code>true</code> if the IDs are equal; 
	   *         <code>false</code> otherwise.
	   */
	  private boolean equals(IProperty p){
	    
	    if (this.id == p.getId()){
	      return true;
	    }
	    
	    return false;
	  }

}
