package simulator.components;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a method as a state inspector. State inspectors allow the simulator
 * to differ methods that are supposed to be monitored from methods
 * that should be ignored (e.g., because they are only important
 * for the agent's internal implementation).
 * 
 * State inspectors differ from parameter inspector in that state
 * can change during simulation, while parameters, once setup, should remain
 * fixed. Hence, state inspectors monitor changes to the underlying component,
 * while parameter inspectors merely present to the user the 
 * parameters in effect.
 * 
 * @author Paulo Salem
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AStateInspector {

  /**
   * @return A user friendly name to the inspector.
   */
  String name() default "(un-named)";

  
  /**
   * @return A user friendly description to the inspector.
   */
  String description() default "(none)";
  
}
