package simulator.agent.relation;

import simulator.util.Assert;

/**
 * An implementation of the ITie interface.
 * 
 * @author Paulo Salem
 */
public class Tie<T> implements ITie<T>{

	/**
	 * The first coordinate of the relational tie.
	 */
	private T first = null;
	
	/**
	 * The second coordinate of the relational tie.
	 */
	private T second = null;
	
	

	/**
	 * Creates a new <code>Tie</code> with the specified objects.
	 * 
	 * @param a The object to be placed in the first coordinate.
	 * @param b The object to be placed in the second coordinate.
	 */
	public Tie(T a, T b){
		Assert.notNull(a);
		Assert.notNull(b);
		
		this.first = a;
		this.second = b;
	}


	///////////////////////////////////////////////////////////////////////////
	// ITie methods
	///////////////////////////////////////////////////////////////////////////
	
	public T first() {
		return first;
	}


	public T second() {
		return second;
	}
	
	
}
