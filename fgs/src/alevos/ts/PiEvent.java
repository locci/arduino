package alevos.ts;

import alevos.expression.picalculus.PiActionPrefix;
import alevos.expression.picalculus.PiInputAction;
import alevos.expression.picalculus.PiOutputAction;

public class PiEvent extends IOEvent {

  /**
   * The action prefix which constitutes this event.
   */
  protected PiActionPrefix prefix;
  
  /**
   * The action that caused this event, if any. For instance, for a tau action to take place,
   * it is necessary that some other two complementary actions react.  
   */
  protected PiActionPrefix cause;


  public PiEvent(PiActionPrefix prefix) {
    super(prefix.getChannel().getIdentifier(), ioType(prefix));
    this.prefix = prefix;
  }
  
  public PiEvent(PiActionPrefix prefix, PiActionPrefix cause) {
    super(prefix.getChannel().getIdentifier(), ioType(prefix));
    this.prefix = prefix;
    this.cause = cause;
  }

  
  private static IOType ioType(PiActionPrefix prefix){
    IOType type;
    
    if(prefix instanceof PiInputAction){
      type = IOType.INPUT;
    }
    else if (prefix instanceof PiOutputAction){
      type = IOType.OUTPUT;
    }
    else{
      type = IOType.OTHER;
    }
    
    return type;
  }
  
  public PiActionPrefix getPrefix() {
    return prefix;
  }
  
  public PiActionPrefix getCause() {
    return cause;
  }

  @Override
  public String toString() {
    
    return prefix.toString();
  }

  @Override
  public boolean equals(Object obj) {
    
    if(obj instanceof PiEvent){
      PiEvent pie = (PiEvent) obj;
      
      if(pie.getPrefix().equals(this.prefix)){
        return true;
      }
    }
    
    return false;
  }

  @Override
  public int hashCode() {
    return prefix.hashCode();
  }
  
  
  
  
}
