package alevos.process.semantics;

import java.util.Collection;
import java.util.LinkedList;

import alevos.IllegalSemanticsException;
import alevos.expression.Expression;
import alevos.expression.picalculus.PiName;
import alevos.expression.picalculus.PiProcess;
import alevos.expression.picalculus.PiRestriction;
import alevos.ts.Event;
import alevos.ts.PiEvent;
import alevos.util.Pair;

public class PiResRule extends Rule {

  @Override
  public Collection<Pair<Event, Expression>> succ(Expression exp) throws IllegalSemanticsException {
    Collection<Pair<Event, Expression>> ees = new LinkedList<Pair<Event, Expression>>();
    
    if(exp instanceof PiRestriction){
      PiRestriction res = (PiRestriction)exp;
      
      for(Pair<Event, Expression> ee: res.getProc().succ()){
        
        // If the event does not contain restricted names...
        if(!contains((PiEvent)ee.getFirst(), res.getRestricted())){
          // ... it might take place on the restricted environment
          ees.add(new Pair<Event, Expression>(ee.getFirst(), new PiRestriction(res.getRestricted(), (PiProcess) ee.getSecond().clone())));
          
        }
      }
     
      
      return ees;
      
    }
    else{
      throw new IllegalArgumentException("This rule is not defined for the specified expression.");
    }
  }

  /**
   * Checks whether the specified event contains some of the specified names.
   * 
   * @param e The event that may contain some names.
   * @param names The names that might belong to the event.
   * @return <code>true</code> if at least one name is contained in the event;
   *         <code>false</code> otherwise.
   */
  protected boolean contains(PiEvent e, Collection<PiName> names){
    
    for(PiName n: names){
      if(e.getPrefix().contains(n)){
        return true;
      }
    }
    
    return false;
  }




}
