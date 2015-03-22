package simulator.analysis;

/**
 * A property whose value is boolean.
 * 
 * @author Paulo Salem
 *
 */
public interface IBooleanProperty{

  /**
   * Calculates whether the property holds w.r.t. the specified bearer.
   * 
   * @param pb The object subject to the property.
   * 
   * @return <code>true</code> if the property holds;
   *         <code>false</code> otherwise.
   */
  public boolean isTrue(PropertyBearerWrapper pb);
}
