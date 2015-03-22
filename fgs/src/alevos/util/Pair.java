package alevos.util;

import java.io.Serializable;

public class Pair<T1, T2> implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private T1 first;
  
  private T2 second;

  public Pair(T1 first, T2 second) {
    super();
    this.first = first;
    this.second = second;
  }

  public T1 getFirst() {
    return first;
  }

  public T2 getSecond() {
    return second;
  }
  
  public String toString(){
    return "(" + first.toString() + ", " + second.toString() + ")";
  }
  
  @Override
  public boolean equals(Object obj){
    if(obj instanceof Pair){
      Pair p = (Pair) obj;
      
      if(p.getFirst().equals(this.getFirst()) && p.getSecond().equals(this.getSecond())){
        return true;
      }
    }
    
    return false;
  }
  
  public int hashCode(){
    return this.getFirst().hashCode() + this.getSecond().hashCode();
  }
}
