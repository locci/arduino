package simulator.components;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a method as a parameter initializer. Such a method can be called
 * by the simulator during <code>Scenario</code> definition, in order
 * to configure the simulation to be performed.
 * 
 * @author Paulo Salem
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AParameterInitializer {

  /**
   * @return A user friendly name to the parameter.
   */
  String name() default "(unamed)";

  
  /**
   * @return A user friendly description to the parameter.
   */
  String description() default "(none)";
}
