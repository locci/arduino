package simulator.engine;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

/**
 * This class merely overrides the <code>resolveClass()</code> method of 
 * <code>ObjectInputStream</code> in order to employ for the correct
 * class loader for deserialization. This is necessary because simulation components
 * are loaded in a special way, and as a result are not available to the 
 * usual deserialization process.
 * 
 * @author Paulo Salem
 *
 */
public class SimulatorObjectInputStream extends ObjectInputStream {

  public SimulatorObjectInputStream(InputStream in) throws IOException {
    super(in);
    
  }
  
  /**
   * Resolves the necessary classes w.r.t. the class loader that manages all the components
   * and libraries.
   */
  //alexandre protected
  public Class<?> resolveClass(ObjectStreamClass desc)  throws IOException, ClassNotFoundException {
    
    // Get the current class loader
    ClassLoader currentCL = Thread.currentThread().getContextClassLoader();
    
    Class<?> c = Class.forName(desc.getName(), false, currentCL);
    
    return c;
  }



}
