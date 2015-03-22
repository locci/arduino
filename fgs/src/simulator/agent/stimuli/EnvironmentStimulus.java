package simulator.agent.stimuli;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import simulator.agent.IAgent;
import simulator.util.Assert;


/**
 * Represents a stimulus that flows through an environment. 
 * This class is immutable, in order to facilitate the sharing of the same stimulus.
 * 
 * @author   Paulo Salem
 */
public class EnvironmentStimulus implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  protected String type = "Unknown type";

  protected String content = "Unlabelled";
  
  protected IAgent source = null;
  
  // TODO sometimes this is undesirable
  protected List<IAgent> referencedAgents = null;
  
  /**
   * Components may have an internal counterpart of the stimulus presented to the environment.
   * This counterpart can be stored in this field, if necessary.
   */
  protected Object internalComponentRepresentation = null;
  
  
  // TODO more properties here. Check UML.
  
  
  public EnvironmentStimulus(String type){
    Assert.notNull(type);
    
    this.type = type;
    this.content = "";
    this.source = null;
    this.referencedAgents = new LinkedList<IAgent>();
    
  }
  
  public EnvironmentStimulus(String type, Object internalComponentRepresentation){
    Assert.notNull(type);
    
    this.type = type;
    this.content = "";
    this.source = null;
    this.referencedAgents = new LinkedList<IAgent>();
    this.internalComponentRepresentation = internalComponentRepresentation; 
    
  }
  
  public EnvironmentStimulus(String type, String content, IAgent source, List<IAgent> referencedAgents){
    Assert.notNull(type);
    Assert.notNull(content);
    Assert.notNull(referencedAgents);
    
    // Note: The source might be null!
    
    
    // Make sure we are copying the strings and not just pointing to the
    // specified strings. This is necessary to make sure agents cannot
    // access directly private variables of others.
    this.type = new String(type);
    this.content = new String(content);
    this.source = source;
    this.referencedAgents = referencedAgents;
  }
  
  
/**
 * If this stimulus refers to other agents, this method  returns such agents. If no references are intended, the method  returns <code>null</code>.
 * @return  A list of <code>IAgent<code>s, if appropriate;  <code>null</code> otherwise.
 */
  public List<IAgent> getReferencedAgents(){
    return referencedAgents;
  }


  /**
 * @return  the content
 */
public String getContent() {
    return content;
  }


  /**
 * @return  the source
 */
public IAgent getSource() {
    return source;
  }


  /**
 * @return  the type
 */
public String getType() {
    return type;
  }

  public Object getInternalComponentRepresentation() {
    return internalComponentRepresentation;
  }


  @Override
  public String toString(){
    return "[Stimulus type='"+ type +"']";
  }
  
  @Override
  public boolean equals(Object obj){
    if(obj instanceof EnvironmentStimulus){
      EnvironmentStimulus s = (EnvironmentStimulus) obj;
      if(this.type.equals(s.type) && this.content.equals(s.content) && this.referencedAgents.equals(s.referencedAgents)){
        // The source is not relevant for the equality of stimuli, nor is the internal representation
        // used by the components
        return true;
      }
    }
    
    return false;
  }
  
  @Override
  public int hashCode(){
    // The source is not relevant for the equality of stimuli, nor is the internal representation
    // used by the components
    return type.hashCode() + content.hashCode() + referencedAgents.hashCode();
  }
  
  
}
