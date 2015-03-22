package alevos.process.semantics;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import alevos.IllegalSemanticsException;
import alevos.expression.Expression;
import alevos.expression.picalculus.PiActionPrefix;
import alevos.expression.picalculus.PiPrefix;
import alevos.expression.picalculus.PiProcess;
import alevos.ts.Event;
import alevos.ts.PiEvent;
import alevos.util.Pair;

public class PiPrefixRule extends Rule {

  
  
  @Override
  public Collection<Pair<Event, Expression>> succ(Expression exp) throws IllegalSemanticsException {
    
    Collection<Pair<Event, Expression>> ees = new LinkedList<Pair<Event, Expression>>();
    
    if(exp instanceof PiPrefix){
      PiPrefix pre = (PiPrefix) exp;
     
      PiEvent e = new PiEvent((PiActionPrefix) pre.getPrefix().clone());
      
      ees.add(new Pair<Event,Expression>(e, (PiProcess)pre.getProcess().clone()));
      
      return ees;
    }
    else{
      throw new IllegalArgumentException("This rule is not defined for the specified expression.");
    }
    
  }

  // TODO remove ??
  /*
  @Override
  public Set<Event> enabled(Expression exp) {

    Set<Event> es = new HashSet<Event>();

    if(exp instanceof PiPrefix){
      PiPrefix pre = (PiPrefix) exp;
     
      PiEvent e = new PiEvent((PiActionPrefix) pre.getPrefix().clone());
      
      es.add(e);
      
      return es;
    }
    else{
      throw new IllegalArgumentException("This rule is not defined for the specified expression.");
    }
    
  }

  @Override
  public Set<Expression> emit(Event e, Expression exp) {
    
    Set<Expression> exps = new HashSet<Expression>();

    if(exp instanceof PiPrefix){
      PiPrefix pre = (PiPrefix) exp;
     
      PiEvent ev = new PiEvent((PiActionPrefix) pre.getPrefix());
      
      if(e.equals(ev)){
        // If the specified event is the guard of this Prefix, then the event can be emitted.
        exps.add((PiProcess)pre.getProcess().clone());
      }
      
      return exps;
    }
    else{
      throw new IllegalArgumentException("This rule is not defined for the specified expression.");
    }
  }

*/
  
  
  
  

}
