package simulator.engine.alevos;

import java.util.Collection;
import java.util.LinkedList;

import simulator.agent.action.EnvironmentAction;
import simulator.agent.stimuli.EnvironmentStimulus;
import alevos.IllegalSemanticsException;
import alevos.expression.Expression;
import alevos.expression.picalculus.PiActionPrefix;
import alevos.process.semantics.Rule;
import alevos.ts.Event;
import alevos.ts.PiEvent;
import alevos.util.Pair;

public class PiEMMASAgentProfileRule extends Rule {

  @Override
  public Collection<Pair<Event, Expression>> succ(Expression exp) throws IllegalSemanticsException {
    
    Collection<Pair<Event, Expression>> ees = new LinkedList<Pair<Event, Expression>>();
    
    if(exp instanceof PiEMMASAgentProfile){
      PiEMMASAgentProfile ap = (PiEMMASAgentProfile)exp;
    
      for(EnvironmentAction ea: ap.getActions()){
        PiActionPrefix prefix = ap.nextClonedPrefixFor(ea);
        PiEMMASAgentProfile nextAgent = ap.clonedAgentAfter(ea);
        
        ees.add(new Pair<Event, Expression>(new PiEvent((PiActionPrefix)prefix.clone()), nextAgent));
      }
      
      for(EnvironmentStimulus es: ap.getStimuli()){
        PiActionPrefix prefix = ap.nextClonedPrefixFor(es);
        PiEMMASAgentProfile nextAgent = ap.clonedAgentAfter(es);
        
        ees.add(new Pair<Event, Expression>(new PiEvent((PiActionPrefix)prefix.clone()), nextAgent));
      }
      
    
      return ees;
    }
    else{
      throw new IllegalArgumentException("This rule is not defined for the specified expression.");
    }
  }

}
