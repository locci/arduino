package alevos.ts;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import alevos.util.Pair;
import alevos.util.Triple;
import alevos.verification.TraceInfo;

/**
 * A transition system in which all elements are explicitly defined a priori.
 * 
 * @author Paulo Salem
 *
 */
public class StaticTransitionSystem extends AnnotatedTransitionSystem{

  protected Set<State> states;
  
  public StaticTransitionSystem(State initial) {
    super(initial);
    
    this.states = new HashSet<State>();

    states.add(initial);
  }

  @Override
  public Collection<Pair<Event, State>> succ(State s, TraceInfo ti) {
    return s.getStaticSuccessors();
  }
  
  @Override
  public Collection<Pair<Event, State>> succ(State s) {
    return succ(s, new TraceInfo());
  }
  
  
  
  
  public void addState(State s){
    states.add(s);
  }
  
  
  public void addTransition(State s1, Event e, State s2){
    
    states.add(s1);
    states.add(s2);
    
    s1.addStaticSuccessor(e, s2);
  }

  
  public Collection<Literal> getLiterals(){
    Set<Literal> ps = new HashSet<Literal>();
    
    for(State s: states){
      ps.addAll(s.getLiterals());
    }
    
    return ps;
  }
  
  public Collection<Event> getEvents(){
    Set<Event> es = new HashSet<Event>();
    
    for(State s: states){
      for(Pair<Event, State> succ: s.getStaticSuccessors()){
        es.add(succ.getFirst());
      }
    }
    
    return es;
  }

  public Collection<Triple<State, Event, State>> getTransitions(){
    
    Set<Triple<State, Event, State>> ts = new HashSet<Triple<State, Event, State>>();

    for(State s: states){
      for(Pair<Event, State> succ: s.getStaticSuccessors()){
        ts.add(new Triple<State, Event, State>(s, succ.getFirst(), succ.getSecond()));
      }
    }
    
    return ts;
  }
  
  
  

  public Set<State> getStates() {
    return states;
  }

  /**
   * Checks whether this transition system is really a simulation purpose
   * (i.e., whether it satisfies the definition of a simulation purpose).
   * 
   * @return <code>true</code> if the simulation purpose is well formed;
   *         <code>false</code> otherwise.
   */
  public boolean isWellFormed(){
    // TODO
    return true;
  }


}
