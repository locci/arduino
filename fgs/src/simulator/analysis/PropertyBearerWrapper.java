package simulator.analysis;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


/**
 * Wraps other objects so that <code>IProperty</code>s can be attached to them.
 * @author  Paulo Salem
 */
public class PropertyBearerWrapper implements Serializable{

	/**
   * 
   */
  private static final long serialVersionUID = 1L;

  /**
	 * The <code>Object</code> being wrapped.
	 */
	private Object target = null;
	
	/**
	 * The name of the wrapper. It is recommended that this name reflects the
	 * wrapped object.
	 */
	private String name = "(Unnamed wrapper)";
	
	/**
 	 * The properties attached to the agent.
	 */
	private List<IProperty> properties = new LinkedList<IProperty>();
	
	
	/**
	 * Creates a new <code>PropertyBearerWrapper</code> wrapping the
	 * specified <code>Object</code>.
	 * 
	 * @param target The <code>Object</code> to be wrapped.
	 * @param name The name to be attributed to the wrapper. It is recommended
	 *             that the name of the wrapper equals the name of the
	 *             wrapped object.
	 */
	public PropertyBearerWrapper(Object target, String name){
		this.target = target;
		this.name = name;
	}
	  
	  
	/**
   * @return  The target object upon which the property's value should be  calculated.
   * @uml.property  name="target"
   */
	public Object getTarget(){
		return target;
	}

	
	/**
   * @return  All <code>IProperty</code>s attached to the wrapped <code>Object</code>.
   * @uml.property  name="properties"
   */
	public List<IProperty> getProperties(){
		  return properties;
	  }
	
	/**
   * @return  the name
   * @uml.property  name="name"
   */
	public String getName(){
		return name;
	}
	

	/**
	 * Attaches a new property to the wrapped <code>Object</code>.
	 * 
	 * @param p The property to be attached.
	 */
	  public void attach(IProperty p){
		  boolean repeated = false;
		  
		  for(IProperty q: properties){
			  if(p.getId() == q.getId()){
				  repeated = true;
			  }
		  }
		  
		  if(!repeated){
			  properties.add(p);
		  }
	  }
	

	/**
	 * Detaches a property from the wrapped <code>Object</code>.
	 * 
	 * @param p The property to be detached.
	 */
	  public void detach(IProperty p){
		  for(IProperty q: properties){
			  if(p.getId() == q.getId()){
				  properties.remove(q);
			  }
		  }
	  }
	
	  
	/**
	 * Checks if the specified <code>PropertyBearerWrapper<code> is equal to this
	 * one.
	 * 
	 * @param pb The <code>PropertyBearerWrapper<code> to be checked.
	 * 
	 * @return <code>true</code> if they are equal;
	 *         <code>false</code> otherwise.
	 */
	  public boolean equals(PropertyBearerWrapper pbw){
		  
		  if(pbw.getTarget().equals(this)){
			  return true;
		  }
		  else{
			  return false;
		  }
	  }
	
	
	
}

	  