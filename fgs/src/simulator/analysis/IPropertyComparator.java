package simulator.analysis;

/**
 * Provides a mechanism to compare the value of a property.
 * This interface should be implemented only by property components.
 * 
 * @author Paulo Salem
 *
 */
public interface IPropertyComparator {

  public enum Comparison {EQUAL, LESS, GREATER};
  
  /**
   * Compares the specified value.
   * 
   * @param value1 The first value.
   * @param value2 The second value.
   * 
   * @return The comparison that relates the first to the second values.
   */
  public Comparison compare(String value1, String value2);
  
  
  /**
   * 
   * @return The minimun value the property might have.
   */
  public String minimumValue();
  
  
  /**
   * 
   * @return The maximum value the property might have.
   */
  public String maximumValue();
  
  // TODO remove?
  /**
   * 
   * @return The property to which this comparator can be applied to.
   */
  //public IProperty getProperty();
}
