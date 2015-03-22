package alevos.expression.picalculus;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public abstract class PiParametrizedActionPrefix extends PiActionPrefix {

  protected List<PiName> parameters;
  
  public PiParametrizedActionPrefix(PiName channel, PiName... names) {
    super(channel);
    
    this.parameters = new LinkedList<PiName>();
    for(int i = 0; i < names.length; i++){
      this.parameters.add(names[i]);
    }
    
  }
  
  public PiParametrizedActionPrefix(PiName channel, List<PiName> parameters) {
    super(channel);
    this.parameters = parameters;
  }
  
  public PiParametrizedActionPrefix(PiName channel, PiName parameter) {
    super(channel);
    
    this.parameters = new LinkedList<PiName>();
    this.parameters.add(parameter);
  }


  public boolean substituteParameters(Map<PiName, PiName> substitution){
    
    boolean b = false;
    
    ListIterator<PiName> it = parameters.listIterator();
    while(it.hasNext()){
      PiName name = it.next();
      
      PiName newName = (PiName) substitution.get(name);
      
      if(newName != null){
        // Substitutes the last element returned by it.next(); 
        it.set(newName);
        b = true; 
      }
      
    }
    
    return b;
  }

  public List<PiName> getParameters() {
    return parameters;
  }
  
  public boolean contains(PiName name){
    
    // Searches on the channel name and on the parameters
    if(this.getChannel().equals(name) ||
        parameters.contains(name)){
      return true;
    }
    
    return false;
        
  }
  
  @Override
  public int size() {
     return 1 + parameters.size();
  }

  public abstract Object clone();
  
  @Override
  public boolean equals(Object obj) {
    
    if(obj instanceof PiParametrizedActionPrefix){
      PiParametrizedActionPrefix ppap = (PiParametrizedActionPrefix) obj;
      
      if(ppap.getChannel().equals(this.channel) &&
          ppap.getParameters().equals(this.parameters)){
        return true;
      }
    }
    
    return false;
  }


  @Override
  public int hashCode() {
    return channel.hashCode() + parameters.hashCode();
  }

  

}
