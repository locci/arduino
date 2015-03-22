package alevos.ts;

/**
 * An event that can be classified as input, output or none.
 * 
 * @author Paulo Salem
 *
 */
public class IOEvent extends Event {
  
  public enum IOType {INPUT, OUTPUT, OTHER, INTERNAL}
  
  private IOType ioType;

  public IOEvent(String name, IOType ioType) {
    super(name);
    this.ioType = ioType;
  }

  public IOType getIoType() {
    return ioType;
  }
  
  public boolean isComplementary(IOEvent e){
    
    if(this.getName().equals(e.getName())){
      
      if(this.getIoType() == IOType.INPUT && e.getIoType() == IOType.OUTPUT){
        return true;
      }
      else if(this.getIoType() == IOType.OUTPUT && e.getIoType() == IOType.INPUT){
        return true;
      }
      else if(this.getIoType() == IOType.OTHER && e.getIoType() == IOType.OTHER){
        return true;
      }
      
    }
    
    return false;
  }
  
  
  
  public boolean isInput(){
    if(ioType.equals(IOType.INPUT)){
      return true;
    }
    
    return false;
  }
  
  public boolean isOutput(){
    if(ioType.equals(IOType.OUTPUT)){
      return true;
    }
    
    return false;
  }
  
  public boolean isOther(){
    if(ioType.equals(IOType.OTHER)){
      return true;
    }
    
    return false;
  }
  
  @Override
  public boolean equals(Object obj){
    if(obj instanceof IOEvent){
      IOEvent evt = (IOEvent) obj;
      if(super.equals(evt) && this.ioType.equals(evt.getIoType())){
        return true;
      }
    }
    
    return false;
  }
  
  @Override
  public int hashCode(){
    return super.hashCode() + ioType.hashCode();
  }
  


}
