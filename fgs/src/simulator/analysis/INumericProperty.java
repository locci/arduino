package simulator.analysis;

public interface INumericProperty {

  /**
   * 
   * @param pbw The target of the property.
   * 
   * @return The value of the property concerning the specified
   *         target.
   */
  public double getValueAsDouble(PropertyBearerWrapper pbw) throws UndefinedPropertyException;
  
  /**
   * 
   * @param o The target of the property.
   * 
   * @return The value of the property concerning the specified
   *         target.
   */
  public double getValueAsDouble(Object o) throws UndefinedPropertyException;
}
