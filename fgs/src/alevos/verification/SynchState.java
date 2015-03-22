package alevos.verification;

import java.util.Collection;
import java.util.List;

import alevos.ts.Event;
import alevos.ts.IOEvent;
import alevos.ts.State;
import alevos.util.Pair;

/**
 * A state on the synchronous product of a simulation purpose and another ATS.
 * 
 * @author Paulo Salem
 *
 */
public class SynchState {
  
  protected State stateSP;
  
  protected State stateATS;
  
  protected IOEvent eventSP;
  
  /**
   * The event in the ATS that led to the present synchronziation.
   */
  protected IOEvent eventATS;
  
  protected State sourceStateSP;
  
  protected Object simulationState;
  
  protected TraceInfo traceInfo;
  
  protected List<Pair<Event, State>> unexplored;
  
  protected int depth;

  public SynchState(State stateSP, State stateATS, IOEvent eventSP, IOEvent eventATS,
      State sourceStateSP, Object simulationState, TraceInfo traceInfo,
      List<Pair<Event, State>> unexplored, int depth) {
    super();
    this.stateSP = stateSP;
    this.stateATS = stateATS;
    this.eventSP = eventSP;
    this.eventATS = eventATS;
    this.sourceStateSP = sourceStateSP;
    this.simulationState = simulationState;
    this.traceInfo = traceInfo;
    this.unexplored = unexplored;
    this.depth = depth;
  }

  public State getStateSP() {
    return stateSP;
  }

  public State getStateATS() {
    return stateATS;
  }

  public IOEvent getEventSP() {
    return eventSP;
  }
  
  public IOEvent getEventATS() {
    return eventATS;
  }

  public State getSourceStateSP() {
    return sourceStateSP;
  }

  public Object getSimulationState() {
    return simulationState;
  }

  public TraceInfo getTraceInfo() {
    return traceInfo;
  }

  public List<Pair<Event, State>> getUnexplored() {
    return unexplored;
  }

  public int getDepth() {
    return depth;
  }
  
  

}
