package alevos.ts;


/**
 * Represents an event in a transition system. Subclasses may add special capabilities to the events.
 * In particular, ALEVOS' clients may extend <code>Event</code> or its subclasses in order to
 * implement domain specific transition systems. In this way, the transition system
 * may be enriched without loss to the basic ALEVOS mechanisms. 
 * 
 * @author Paulo Salem
 *
 */
public class Event {
  
  /**
   * A name that identifies the event.
   */
  private String name;
  
  public Event(String name) {
    super();
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString(){
    return name;
  }

  @Override
  public boolean equals(Object obj){
    if(obj instanceof Event){
      Event evt = (Event) obj;
      if(this.name.equals(evt.getName())){
        return true;
      }
    }
    
    return false;
  }
  
  @Override
  public int hashCode(){
    return name.hashCode();
  }
  
}
