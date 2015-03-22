package simulator.components;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a method as a parameter inspector. Such a method can be called
 * at any time, in order to discover what parameters are in effect.
 * 
 * @author Paulo Salem
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ParameterInspector {
  
  /**
   * @return A user friendly name to the parameter.
   */
  String name() default "(unamed)";

  
  /**
   * @return A user friendly description to the parameter.
   */
  String description() default "(none)";

}
