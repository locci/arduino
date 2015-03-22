package simulator.environment.esl;

import simulator.agent.action.EnvironmentAction;
import alevos.IllegalSemanticsException;
import alevos.expression.picalculus.PiProcess;

public class Action extends ESLStructure {

  String name;
  
  public Action(String name) {
    super();
    this.name = name;
  }


  @Override
  public PiProcess toPiProcess(Context context) throws IllegalSemanticsException {
    // TODO Auto-generated method stub
    return null;
  }
  
  public EnvironmentAction toEnvironmentAction(){
    return new EnvironmentAction(name);
  }

}
