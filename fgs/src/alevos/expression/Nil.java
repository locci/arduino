package alevos.expression;

public class Nil extends Expression {

  @Override
  public Object clone() {
    return new Nil();
  }

  @Override
  public String toString() {
    return "nil";
  }

  @Override
  protected void cleanUp() {
    // Nothing to clean up here
    
  }

  @Override
  public int size() {
    return 1;
  }
  
  @Override
  public int cachedSuccessorsSize() {
    return 0;
  }

}
