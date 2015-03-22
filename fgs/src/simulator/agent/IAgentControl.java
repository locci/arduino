package simulator.agent;

import org.jdom.Element;

import simulator.environment.IEnvironment;


/**
 * Provides the infrastructural interface that allows the simulator to control the agent.
 * 
 * @author   Paulo Salem
 */
public interface IAgentControl {
  
  /**
   * Instructs the agent to update its internal state as if
   * one time unit has passed.
   */
  public void step();
  
  /**
   * Sets the proxy for the agent. Each simulator.agent must know its proxy
   * in order to make self references (i.e., agents cannot use
   * the <code>this</code> keyword in order to refer to themselves).
   * 
   * @param proxy
   */
  public void setAgentProxy(AgentProxy proxy);
  
  /**
   * Returns a reference to this agent's proxy. All self-references 
   * should be made using this method.
   * 
   * @return A reference to this agent's proxy.
   */
  public IAgent me();
  
  public IAgent getAgent();
  
  /**
   * @param  id
   */
public void setId(int id);
  
  /**
   * @return
   */
public int getId();
  
  public void setName(String name);
  
  public void setEnvironment(IEnvironment environment);
  
  
  /**
   * 
   * @return A textual representation of the agent's state.
   */
  public String toString();
  

  // TODO substitute for a more generic affiliation mechanism
 /**
  * 
  * @return The affiliation of the agent.
  */  
  public String affiliation ();
  

}
