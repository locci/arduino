package alevos.expression.picalculus;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Useful auxiliary procedures for pi-calculus manipulation.
 * 
 * @author Paulo Salem
 *
 */
public class PiCalculusHelper {

  /**
   * Creates a substitution map that takes elements to fresh elements.
   * 
   * @param original The elements to be substituted.
   * @return A map with the substitution.
   */
  protected static Map<PiName, PiName> freshSubstitution(Collection<PiName> original){
    
    Map<PiName, PiName> substitution = new HashMap<PiName, PiName>();
    
    for(PiName n: original){
      substitution.put(n, new PiName());
    }
    
    return substitution;
  }
  
  /**
   * Calculates the intersection of the two collections.
   * 
   * @param names1 The first collection of names.
   * @param names2 The second collection of names.
   * 
   * @return A new set that is the intersection of the two specified ones.
   */
  public static Set<PiName> intersection(Collection<PiName> names1, Collection<PiName> names2){
    
    Set<PiName> inter = new HashSet<PiName>();
    
    for(PiName m: names1){
      for(PiName n: names2){
        if(m.equals(n)){
          inter.add(m);
        }
      }
    }
    
    return inter;
    
  }
}
