package simulator.environment;

import java.util.List;

import simulator.agent.AgentProxy;
import simulator.agent.IAgent;
import simulator.agent.relation.IRelation;
import simulator.agent.relation.RelationProxy;


public interface ISocialNetwork {
  
  public List<IRelation> getRelations();
    
  public IRelation<IAgent> getRelation(int id);
  
  public List<IAgent> getNeighbors(IAgent agent);
  
  public List<IAgent> getNeighbors(IAgent agent, int relationId);


}
