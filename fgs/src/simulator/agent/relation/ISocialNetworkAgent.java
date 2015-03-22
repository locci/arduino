package simulator.agent.relation;

import java.util.List;

import simulator.agent.IAgent;


public interface ISocialNetworkAgent {

  /**
   * @return A list of this agent's neighbors.
   */
  public List<IAgent> getNeighbors();
  
  /**
   * Fetches the neighbors of this agent within the specified relation. 
   * 
   * @param relationId The relation to be fetched.
   * 
   * @return A list of this agent's neighbors within the specified relation;
   */
  public List<IAgent> getNeighbors(int relationId);
}
