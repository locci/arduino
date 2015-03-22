package simulator.components;

import org.jdom.Element;

/**
 * Defines an interface by which a component can load its configuration through a
 * XML specification. This is particularly useful when it makes sense to delegate the control
 * over the input format to the component itself. For example, in adapting existing software
 * to work as a component, or when there is no good reason to provide a general
 * parameter setter for something which is very specific to a component.
 * 
 * @author Paulo Salem
 *
 */
public interface IXMLComponentInitializer {
  
  /**
   * Initializes the component with the specified XML structure.
   * 
   * @param domElement The XML structure that the component is capable of loading.
   */
  public void initialize(Element domElement); 
  // TODO would it be possible to load a Document object instead?

}
