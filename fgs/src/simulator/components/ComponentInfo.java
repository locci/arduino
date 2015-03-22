package simulator.components;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * General information about a particular component.
 * 
 * @author Paulo Salem
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ComponentInfo {
  
/**
 * The type of the component.
 */
public enum ComponentType{AGENT, PROPERTY}
  
  /**
   * Each component has a unique identifier.
   * 
   * @return A unique identifier.
   */
  String id();
  
  /**
   * Each component has a version. The same component id
   * may be associated with several versions.
   * 
   * @return The version of the component.
   */
  int version();
  
  /**
   * 
   * @return A user friendly name.
   */
  String name();
  
  /**
   * 
   * @return A user friendly description.
   */
  String description();
  

  /**
   * 
   * @return The type of this component.
   */
  ComponentType type();

}
