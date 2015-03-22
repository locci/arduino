package simulator.agent.relation;

import java.util.List;

public interface IRelation<T> {

  
  public void add(T a, T b);
  
  public void remove(T a, T b);
  
  /**
   * 
   * @return A list of all ordered pairs that belong to this relation.
   */
  public List<ITie<T>> ties();

  
  /**
   * 
   * @return A list of all the elements that are related in this relation. 
   */
  public List<T> members();
  
  /**
   * Let <code>R: A x B</code> be the relation controlled by this interface
   * and <code>a</code> the specified element. 
   * Then the relational image of <code>R</code> with respect to <code>a</code>
   * is the set of all elements 
   * <code>b</code> of <code>B</code> such that <code>(a, b)</code> 
   * belongs to <code>R</code>.
   * 
   * @param a The element with respct to wich the relational image is to be calculated.
   * 
   * @return The inverse relational image with respect to the specified element.
   */
  public List<T> relationalImage(T a);
  

  /**
   * Let <code>R: A x B</code> be the relation controled by this interface
   * and <code>b</code> the specified element. 
   * Then the inverse relational image of <code>R</code> with respect to <code>b</code>
   *  is the set of all elements 
   * <code>a</code> of <code>A</code> such that <code>(a, b)</code> 
   * belongs to <code>R</code>.
   * 
   * @param b The element with respct to wich the relational image is to be calculated.
   * 
   * @return The inverse relational image with respect to the specified element.
   */
  public List<T> inverseRelationalImage(T b);
  
  /**
   * Every relation has a unique ID withing a simulation.
   * 
   * @return The relation's unique ID.
   */
  public int getId();

  
  /**
   * 
   * @return A user friendly name.
   */
  public String getName();
  
  
  /**
   * 
   * @return A user friendly description.
   */
  public String getDescription();
  
  public String toString();
}
