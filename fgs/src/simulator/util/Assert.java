package simulator.util;

/**
 * Provides general assertion capabilities. 
 * 
 * @author Paulo Salem
 *
 */
public class Assert {


  public static void notNull(Object o){
    if(o == null){
      throw new IllegalArgumentException("A non-null parameter must be specified.");
    }
  }

  public static void notNull(Object o, String msg){
    if(o == null){
      throw new IllegalArgumentException(msg);
    }
  }
  
  public static void nonNegative(int i){
    if(i < 0){
      throw new IllegalArgumentException("A non-negative parameter must be specified.");
    }
  }
  
  public static void nonNegativeNonZero(int i){
    if(i <= 0){
      throw new IllegalArgumentException("A non-negative parameter must be specified.");
    }
  }
  
  public static void isInInterval(int i, int min, int max){
    if(i < min || i > max){
      throw new IllegalArgumentException("The specified number must be in the specified interval.");
    }
  }
  
  public static void isInInterval(double i, double min, double max){
    if(i < min || i > max){
      throw new IllegalArgumentException("The specified number must be in the specified interval.");
    }
  }

}
