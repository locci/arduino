package alevos.util;

import java.io.Serializable;

public class Triple<T1, T2, T3> extends Pair<T1, T2> implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;


  private T3 third;

  public Triple(T1 first, T2 second, T3 third) {
    super(first, second);
    this.third = third;
  }

  public T3 getThird() {
    return third;
  }
  
  
}
