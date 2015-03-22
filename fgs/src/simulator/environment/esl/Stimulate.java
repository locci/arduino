package simulator.environment.esl;

import java.util.LinkedList;
import java.util.List;

import alevos.IllegalSemanticsException;
import alevos.expression.picalculus.PiProcess;

public class Stimulate extends ESLOperation {

  Stimulus stimulus;
  
  AgentProfile agent;

  public Stimulate(Stimulus stimulus, AgentProfile agent) {
    super();
    this.stimulus = stimulus;
    this.agent = agent;
  }
  
  @Override
  public PiProcess toPiProcess(Context context) throws IllegalSemanticsException {
    
    List<ESLOperation> ops = new LinkedList<ESLOperation>();
    ops.add(new BeginStimulation(stimulus, agent));
    ops.add(new EndStimulation(stimulus, agent));
    
    SequentialComposition sc = new SequentialComposition(ops);
    
    return sc.toPiProcess(context);
  }

}
