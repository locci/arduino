package simulator.environment.esl;

import simulator.agent.stimuli.EnvironmentStimulus;
import alevos.IllegalSemanticsException;
import alevos.expression.picalculus.PiProcess;

public class Stimulus extends ESLStructure {
  
  String name;

  public Stimulus(String name) {
    super();
    this.name = name;
  }

  @Override
  public PiProcess toPiProcess(Context context) throws IllegalSemanticsException {
    // TODO Auto-generated method stub
    return null;
  }

  public EnvironmentStimulus toEnvironmentStimulus(){
    return new EnvironmentStimulus(name);
  }
}
