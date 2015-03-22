package alevos.util;

import java.io.Serializable;

public class Sextuple<T1, T2, T3, T4, T5, T6> extends Quintuple<T1, T2, T3, T4, T5> implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  private T6 sixth;

  
  
  
  public Sextuple(T1 first, T2 second, T3 third, T4 fourth, T5 fifth, T6 sixth) {
    super(first, second, third, fourth, fifth);
    this.sixth = sixth;
  }




  public T6 getSixth() {
    return sixth;
  }
  
  
}
