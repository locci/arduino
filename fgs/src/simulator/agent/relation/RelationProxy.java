package simulator.agent.relation;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import simulator.Scenario;
import simulator.agent.IAgent;
import simulator.util.Assert;

/**
 * Controls the access to a specific <code>Relation</code>
 * 
 * @author Paulo Salem
 */
public class RelationProxy implements IRelation<IAgent>, Serializable{
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  /**
   * The actual relation that this proxy represents.
   */  
  private IRelation<IAgent> relation = null;
  
  /**
   * The scenario that the relation refers to.
   */
  private Scenario scenario;

  public RelationProxy(IRelation<IAgent> relation, Scenario scenario){
    Assert.notNull(relation);
    Assert.notNull(scenario);
    
    this.relation = relation;   
    this.scenario = scenario;
  }
  
  public void add(IAgent a, IAgent b) {
    relation.add(a, b);
  }
  
  /////////////////////////////////////////////////////////////////////////////
  // IRelation methods
  /////////////////////////////////////////////////////////////////////////////

  public List<IAgent> relationalImage(IAgent a) {
    
    // Must recreate the relational image using proxies
    
    List<IAgent> image = new LinkedList<IAgent>();
    
    for(IAgent b: relation.relationalImage(a)){
      b = scenario.createAgentProxy(b);
      image.add(b);
    }

    return image;
  }
  
  public List<IAgent> inverseRelationalImage(IAgent a) {
    
    // Must recreate the relational image using proxies
    
    List<IAgent> image = new LinkedList<IAgent>();
    
    for(IAgent b: relation.inverseRelationalImage(a)){
      b = scenario.createAgentProxy(b);
      image.add(b);
    }

    return image;
  }

  public void remove(IAgent a, IAgent b) {
    relation.remove(a, b);
    
  }
  
  public List<ITie<IAgent>> ties(){
    
    // Must recreat every tie using proxies
    
    List<ITie<IAgent>> members = new LinkedList<ITie<IAgent>>();
    
    for(ITie<IAgent> t: relation.ties()){
      IAgent a = scenario.createAgentProxy(t.first());
      IAgent b = scenario.createAgentProxy(t.second());
      
      ITie<IAgent> u = new Tie<IAgent>(a, b);
      members.add(u);
    }
    
	  return members;
  }
  
  public List<IAgent> members(){
    
    // Must recreat every member using proxies
    
    List<IAgent> members = new LinkedList<IAgent>();
    
    for(IAgent x: relation.members()){
      IAgent a = scenario.createAgentProxy(x);
      members.add(a);
    }
    
    return members;
    
  }

  public String getDescription() {
    
    return relation.getDescription();
  }

  public int getId() {
    
    return relation.getId();
  }

  public String getName() {

    return relation.getName();
  }
  
  
  /////////////////////////////////////////////////////////////////////////////
  // Proxy management methods
  /////////////////////////////////////////////////////////////////////////////

  /**
   * Sets a the new relation that this proxy must refer to.
   * 
   * @param relation The actual relation.
   */  
  public void setRelation(IRelation<IAgent> relation){
    Assert.notNull(relation);
   
    this.relation = relation;   
  }
}
