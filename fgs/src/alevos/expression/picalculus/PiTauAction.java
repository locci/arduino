package alevos.expression.picalculus;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PiTauAction extends PiActionPrefix {

  protected static PiName tau = new PiName("TAU");
 
  public PiTauAction(){
    super(tau);
  }
  
  @Override
  public int size() {
    return 1;
  }
  
  
  @Override
  public Object clone() {
    return new PiTauAction();
  }



  @Override
  public String toString() {
    return tau.toString();
  }



  @Override
  public boolean complementary(PiActionPrefix action) {
    // The TAU action has no complement.
    return false;
  }

  @Override
  public Set<PiName> boundNames() {
    
    return new HashSet<PiName>();
  }

  @Override
  public Set<PiName> freeNames() {
    
    return new HashSet<PiName>();
  }


  @Override
  public boolean substitute(Map<PiName, PiName> substitution) {
    // Does nothing.
    return false;
    
  }


  @Override
  public boolean contains(PiName name) {
    // Tau does not contain any name
    return false;
  }


  @Override
  public boolean equals(Object obj) {
    
    if(obj instanceof PiTauAction){
      PiTauAction pta = (PiTauAction) obj;
      
      if(pta.getChannel().equals(this.channel)){
        return true;
      }
    }
    
    return false;
  }


  @Override
  public int hashCode() {
    return channel.hashCode();
  }
}
