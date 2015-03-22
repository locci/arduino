package alevos.ts;

public class Literal {
  
  public enum Type {POSITIVE, NEGATIVE};
  
  /**
   * The proposition that concerns this literal.
   */
  protected String proposition;
  
  /**
   * Whether it is a negative literal or not.
   */
  protected Type type = Type.NEGATIVE;
  
  public Literal(String name) {
    super();
    this.proposition = name;
    this.type = Type.NEGATIVE; // By default, it is a positive literal
  }
  

  public Literal(String proposition, Type type) {
    super();
    this.proposition = proposition;
    this.type = type;
  }


  public String getName() {
    return proposition;
  }

  
  


  public Type getType() {
    return type;
  }


  @Override
  public String toString(){
    
    String s = "";
    if(type == Type.NEGATIVE){
      s += "not ";
    }
    
    s += proposition;
    
    return s;
  }
  
  @Override
  public boolean equals(Object obj){
    if(obj instanceof Literal){
      Literal p = (Literal) obj;
      
      if(this.proposition.equals(p.getName()) && this.getType().equals(p.getType())){
        return true;
      }
    }
    
    return false;
  }
  
  @Override
  public int hashCode(){
    return proposition.hashCode() + type.hashCode();
  }
  
  

}
