package alevos.util;

import java.io.Serializable;

public class Quadruple<T1, T2, T3, T4> extends Triple<T1, T2, T3> implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;


  private T4 fourth;

  public Quadruple(T1 first, T2 second, T3 third, T4 fourth) {
    super(first, second, third);
    this.fourth = fourth;
  }

  public T4 getFourth() {
    return fourth;
  }


  
  
  
  
}
