package simulator.agent.relation;

/**
 * Represents a relational tie, that is, an ordered pair. It is required that 
 * classes that implement <code>ITie</code> provide a constructor which 
 * is parametrized by two objects to compose the ordered pair. 
 * 
 * @author Paulo Salem
 */
public interface ITie<T> {

	/**
	 * 
	 * @return The object in the first coordinate of the relational tie.
	 */
	public T first();
	
	
	/**
	 * 
	 * @return The object in the second coordinate of the relational tie.
	 */
	public T second();
}
