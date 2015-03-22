package alevos.expression.picalculus;

import java.util.Map;
import java.util.Set;

public abstract class PiActionPrefix implements Cloneable{

  protected PiName channel;
  
  public PiActionPrefix(String name){
    PiName pn = new PiName(name);
    this.channel = pn;
  }
  
  public PiActionPrefix(PiName channel) {
    super();
    this.channel = channel;
  }

  public abstract boolean complementary(PiActionPrefix action);

  
  /**
   * Calculates how many pi-names compose this action prefix.
   * 
   * @return the quantity of elements that composes this action prefix.
   */
  public abstract int size();
  
  @Override
  public abstract String toString();
  
  @Override
  public abstract Object clone();

  /**
   * Uses the specified map to substitute names in the prefix.
   * 
   * @param substitution A map from original names to the ones that should substitute them.
   */
  public abstract boolean substitute(Map<PiName, PiName> substitution);

  /**
   * Substitutes the channel of this action if necessary according to the 
   * specified mapping.
   * 
   * @param substitution A substitution mapping.
   */
  public boolean substituteChannel(Map<PiName, PiName> substitution) {
    
    if(substitution.containsKey(this.channel)){
      this.channel = substitution.get(this.channel);
      return true;
    }
    
    return false;
    
  }
  
  /**
   * Calculates the bound names of the prefix.
   * 
   * @return A set with the bound names.
   */
  public abstract Set<PiName> boundNames();
  
  /**
   * Calculates the free names of the prefix.
   * 
   * @return A set with the free names.
   */
  public abstract Set<PiName> freeNames();


  /**
   * Checks whether the specified name is used in this action prefix.
   * 
   * @param name The name to be looked up.
   * @return <code>true</code> if this action prefix contains the specified name;
   *         <code>false</code> otherwise.
   */
  public abstract boolean contains(PiName name);
  
  public PiName getChannel() {
    return channel;
  }
  
  @Override
  public abstract boolean equals(Object obj);
  
  @Override
  public abstract int hashCode();


}
