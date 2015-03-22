package simulator.environment.esl;

import java.util.HashMap;
import java.util.Map;

public class Context {
  
  Map<String, ESLExpression> values = new HashMap<String, ESLExpression>();
  
  public void addValue(String variableName, ESLExpression value){
    values.put(variableName, value);
  }
  
  public ESLExpression getValue(String variableName){
    return values.get(variableName);
  }

}
