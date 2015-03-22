package simulator.visualization;

import java.awt.Color;

import simulator.util.Assert;

/**
 * Contains the visual properties of a vertex.
 * 
 * @author Paulo Salem
 *
 */
public class VertexVisualProperties {

  private Color color;
  
  
  public VertexVisualProperties(Color color){
    Assert.notNull(color);
    
    this.color = color;
  }
  
  
  public void setColor(Color color){
    Assert.notNull(color);
    
    this.color = color;
  }
  
  public Color getColor(){
    return color;
  }
  
  
}
