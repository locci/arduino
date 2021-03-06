package simulator.components;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Element;

import simulator.util.Assert;


/**
 * Holds the description of a component's instance parameters. 
 * @author  Paulo Salem
 */
public class ComponentParameters implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  /**
   * The ID of the component that is parametrized by this instance.
   * @uml.property  name="componentId"
   */
  private String componentId = "";
  
  /**
   * A custom XML initializer that can be passed to the component.
   */
  private Element initializer = null;
  
  /**
   * A map from parameter name to parameter value. Values that are not <code>String</code>s will be properly converted when component  configuration takes place.
   * @uml.property  name="primitiveParameters"
   * @uml.associationEnd  qualifier="key:java.lang.Object java.lang.String"
   */
  private Map<String, String> primitiveParameters = new HashMap<String, String>();

  /**
   * A map form parameter name to a list of strings, which is the value of the
   * parameter.
   */
  private Map<String, List<String>> listParameters = new HashMap<String, List<String>>();
  
  public ComponentParameters(String componentId){
    //check primitiveParameters
    Assert.notNull(componentId);
    
    
    this.componentId = componentId;
  }
  
  
  /**
   * Adds a new parameter to the parameters list. Parameters must
   * be added only once.
   * 
   * @param name The parameter's name.
   * @param value The parameter's value.
   */
  public void addParameter(String name, String value){
    
    //check primitiveParameters
    if (name == null || value == null){
      throw new IllegalArgumentException("Please specify non-null name and value.");
    }
    
    // Do not allow the same parameter to be defined twice
    if (primitiveParameters.containsKey(name)){
      throw new IllegalArgumentException("The specified parameter is already defined.");
    }
    primitiveParameters.put(name, value);
  }
  
  
  /**
   * Adds a new list parameter to the parameter list. Parameters must
   * be added only once.
   * 
   * @param name The parameter's name.
   * @param value The parameter's value.
   */
  public void addParameter(String name, List<String> value){
    
    //check primitiveParameters
    if (name == null || value == null){
      throw new IllegalArgumentException("Please specify non-null name and value.");
    }
    
    // Do not allow the same parameter to be defined twice
    if (listParameters.containsKey(name)){
      throw new IllegalArgumentException("The specified parameter is already defined.");
    }
    
    listParameters.put(name, value);
  }
  
  public void setInitializer(Element initializer){
    Assert.notNull(initializer);
    
    this.initializer = initializer;
  }
  
/**
 * @return  the componentId
 * @uml.property  name="componentId"
 */
public String getComponentId(){
	return componentId;
  }
  
  public String getPrimitiveParameter(String name){
    return primitiveParameters.get(name);
  }
  
  public List<String> getListParameter(String name){
    return listParameters.get(name);
  }
  
/**
 * @return  The primitive parameters list.
 * @uml.property  name="primitiveParameters"
 */
  public Map<String, String> getPrimitiveParameters(){
    return primitiveParameters;
  }
  
  /**
   * @return  The list parameters list.
   */
    public Map<String, List<String>> getListParameters(){
      return listParameters;
    }  
    
    public Element getInitializer(){
      return initializer;
    }
}
