package simulator.visualization.jung;

import java.awt.Color;
import java.awt.Paint;

import edu.uci.ics.jung.graph.decorators.ConstantVertexPaintFunction;
import edu.uci.ics.jung.graph.decorators.VertexPaintFunction;
import edu.uci.ics.jung.visualization.PluggableRenderer;


/**
 * A renderer to visualize social networks.
 * 
 * @author Paulo Salem
 *
 */
public class SocialNetworkRenderer extends PluggableRenderer {


  public SocialNetworkRenderer(){
    Paint p1 = new Color(255, 255, 255);
    Paint p2 = new Color(0, 0, 0);
    VertexPaintFunction vpf = new ConstantVertexPaintFunction(p1, p2);
    this.setVertexPaintFunction(vpf);
  }

  
}
