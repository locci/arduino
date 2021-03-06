package simulator.engine.strategy;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import simulator.util.Assert;

public class RandomCombinationIterator<T> implements Iterator<List<T>>{

  /**
   * The elements whose combination is desired.
   */
  private List<T> elements;
  
  /**
   * How many combinations to (randomly) generate.
   */
  private int trials;
  
  /**
   * How many members each combinations should have.
   */
  private int k;
  
  /**
   * How many combinations have been generated since the instantiation.
   */
  private int generated = 0;
  
  
  public RandomCombinationIterator(List<T> elements, int k, int trials){
    Assert.notNull(elements);
    
    if(elements.size() < k){
      throw new IllegalArgumentException ("The combination size must be less than or equal to the number of elements in the sequence.");
    }
    
    this.elements = elements;
    this.k = k;
    this.trials = trials;
    
  }
  
  @Override
  public boolean hasNext() {
    
    // There is another possibility iff we have not generated all requested trials.
    if(generated < trials){
      return true;
    }
    
    return false;
  }

  
  @Override
  public List<T> next() {
    if(hasNext()){
      List<T> result = new LinkedList<T>();
      
      // For each combination position, choose a random element
      for(int i = 0; i < k; i++){
        
        double p = Math.random();
        
        // The last possible index for the elements
        double n = (elements.size() - 1);
        
        // The random index to use to choose an element
        int j = (int) Math.floor(p * n);
        
        result.add(i, elements.get(j));
      }
      
      // increase the counter of generated combinations
      generated++;
      
      return result;
    }
    else{
      throw new NoSuchElementException("There are no more combinations.");
    }
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException ("Elements cannot be removed from the sequence.");
  }

}
