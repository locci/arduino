package alevos.expression.picalculus;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PiOutputAction extends PiParametrizedActionPrefix {

  public PiOutputAction(PiName channel, PiName... parameters) {
    super(channel, parameters);
  }
  
  public PiOutputAction(PiName channel, List<PiName> parameters) {
    super(channel, parameters);
  }

  public PiOutputAction(PiName channel, PiName parameter) {
    super(channel, parameter);
  }
  
  @Override
  public Object clone() {
    List<PiName> newParameters = new LinkedList<PiName>();
    newParameters.addAll(parameters);
    
    return new PiOutputAction(this.channel, newParameters);
  }
  
  @Override
  public String toString() {
    String s = "!" + channel.toString() + "<";
    
    Iterator<PiName> it = parameters.iterator();
    while(it.hasNext()){
      PiName n = it.next();
      s = s +  n.toString();
      
      if(it.hasNext()){
        s = s + ", ";
      }
    }
    
    s = s + ">";
    
    return s;
  }

  @Override
  public boolean complementary(PiActionPrefix action) {

    // Must have the same channel name and be an input to be complementary 
    // to this output action
    if(action.getChannel().equals(this.getChannel()) &&
        action instanceof PiInputAction){
      
      return true;
    }
    else{
      return false;
    }

  }

  @Override
  public Set<PiName> boundNames() {

    // Returns an empty set
    return new HashSet<PiName>();
  }

  @Override
  public Set<PiName> freeNames() {
    
    Set<PiName> free = new HashSet<PiName>();
    
    free.add(this.channel);
    free.addAll(this.parameters);
    
    return free;
  }

  @Override
  public boolean substitute(Map<PiName, PiName> substitution) {
    
    // Since output action does not bind names, we substitute both the channel name
    // and the parameters
    boolean b1 = this.substituteChannel(substitution);
    boolean b2 = this.substituteParameters(substitution);
    
    if(b1 || b2){
      return true;
    }
    
    return false;
    
  }
}
