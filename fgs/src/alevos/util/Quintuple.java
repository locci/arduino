package alevos.util;

import java.io.Serializable;

public class Quintuple<T1, T2, T3, T4, T5> extends Quadruple<T1, T2, T3, T4> implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;


  private T5 fifth;

  public Quintuple(T1 first, T2 second, T3 third, T4 fourth, T5 fifth) {
    super(first, second, third, fourth);
    this.fifth = fifth;
  }

  public T5 getFifth() {
    return fifth;
  }


  
  
  
  
}
