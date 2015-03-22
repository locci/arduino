package simulator.components;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import alevos.simulation.InvalidSimulatorRequest;

import simulator.agent.IAgentControl;
import simulator.analysis.IProperty;
import simulator.engine.SimulatorObjectInputStream;
import simulator.environment.IEnvironment;
import simulator.io.ScenarioLoadingException;
import simulator.util.Assert;
import teste.Main;
import testex.ChamaMain;
import testex.GeraEx;
import testex.ListaDeExDisparada;




/**
 * <code>ComponentsRegistry</code> mantains a list of all available components.
 * It is also responsible for instantiating components.
 * 
 * @author Paulo Salem
 */
public class ComponentsRegistry {
  
  /**
   * A map that take component IDs to component classes.
   */
  protected HashMap<String, Class> components = new HashMap<String, Class>();
  




  /**
   * Instantiates a new <code>IAgentControl</code> associated
   * with the specified component parameters and scenario.
   * 
   * @param cp The parameters for the new component instance.
   * @param environment The environment to which the agent belongs.
   * 
   * @return A new <code>IAgentControl</code> if the specified ID exists;
   *         <code>null</code> otherwise.
 * @throws InvalidSimulatorRequest 
 * @throws ClassNotFoundException 
 * @throws IOException 
 * @throws ScenarioLoadingException 
 * @throws NoSuchStateInspectorException 
   */public ComponentParameters cp2; public IEnvironment environment2;
  public IAgentControl createAgentControl(ComponentParameters cp, IEnvironment environment) throws ComponentInstantiationException, NoSuchStateInspectorException, ScenarioLoadingException, IOException, ClassNotFoundException, InvalidSimulatorRequest{
   
    
    try { cp2 = cp; environment2 = environment;
    	
       //IAgentControl ac = (IAgentControl) components.get("organism.OrganismComponent").newInstance();
    	//alexandre 27/12 16:27
    	//SimulatorObjectInputStream ois2 = new SimulatorObjectInputStream(null);
    	//ois2.resolveClass(null);
      IAgentControl ac = (IAgentControl) components.get(cp.getComponentId()).newInstance();
        
      // Configure standard parameters
      ac.setId(new Integer(cp.getPrimitiveParameter("id"))); 
      ac.setName(cp.getPrimitiveParameter("name"));
      
      // Setup environment
      ac.setEnvironment(environment);
      
      // Initialize with custom XML, if the relevant interface is present
      if(ac instanceof IXMLComponentInitializer){
        IXMLComponentInitializer xc = (IXMLComponentInitializer) ac;
        xc.initialize(cp.getInitializer());
      }
      
      // Configure other primitive parameters
      for(String p: cp.getPrimitiveParameters().keySet()){

        callPrimitiveParameterInitializer(components.get(cp.getComponentId()), 
                                          ac, 
                                          p, 
                                          cp.getPrimitiveParameter(p));
      }
      
      // Configure list parameters
      for(String p: cp.getListParameters().keySet()){

        callListParameterInitializer(components.get(cp.getComponentId()), 
                                          ac, 
                                          p, 
                                          cp.getListParameter(p));
      }
      
      //
      // TODO configure other types of parameters (e.g., map)
      // Main.main(null);
     
      //if(ChamaMain.sorteio("1")) GeraEx.geraEx("Exception"); 
      return ac;
      
    } catch (Exception e) {
      e.printStackTrace(); //this.createAgentControl(cp2, environment2);
      throw new ComponentInstantiationException("Could not create the requested agent.", e);
    } 
  }

  
  public IProperty createProperty(ComponentParameters cp, IEnvironment environment) throws ComponentInstantiationException{
	    
	    try {
	    	//alexandre 27/12 16:27
	    	//SimulatorObjectInputStream ois2 = new SimulatorObjectInputStream(null);
	    	//ois2.resolveClass(null);
	    	
	    	IProperty p = (IProperty) components.get(cp.getComponentId()).newInstance();
	  
	      // Configure standard parameters
	      p.setId(new Integer(cp.getPrimitiveParameter("id")));
	      p.setName(cp.getPrimitiveParameter("name"));
        
        // Set environment
        p.setEnvironment(environment);
	      
	      // Configure primitive parameters
	      for(String par: cp.getPrimitiveParameters().keySet()){

	        callPrimitiveParameterInitializer(components.get(cp.getComponentId()), 
	                                          p, 
	                                          par, 
	                                          cp.getPrimitiveParameter(par));
	      } 
	      
        // Configure list parameters
        for(String par: cp.getListParameters().keySet()){

          callListParameterInitializer(components.get(cp.getComponentId()), 
                                            p, 
                                            par, 
                                            cp.getListParameter(par));
        }        
	      //
	      // TODO configure other types of parameters (list, map)
	      //
	  
          //if(ChamaMain.sorteio("2")) GeraEx.geraEx("Exception"); 
	      return p;
	      
	    } catch (Exception e) {
	      e.printStackTrace();
	      throw new ComponentInstantiationException("Could not create the requested agent.", e);
	    }
	  }

  
  /**
   * Registers the specified class as a component. 
   * 
   * @param componentClass The class of the component.
   */
  public void registerComponent(Class componentClass){
	
    //Assert.notNull(componentClass);
  
	 AComponentInfo ci = (AComponentInfo)componentClass.getAnnotation(AComponentInfo.class);

    // If the annotation do not exist, we do not have a component
    if(ci == null){
      throw new IllegalArgumentException("The specified class is not a component.");
    }
    
    // If the component has already being registered, we raise an exception
    if(components.keySet().contains(ci.id())){
      throw new IllegalArgumentException("The specified component is already registered.");
    }
    
    // If everything is ok, we register the component
    components.put(ci.id(), componentClass);
    
    
  }
  
  /**
   * Checks whether the specified component ID is already registered.
   * 
   * @param componentID The component ID to chek.
   * 
   * @return <code>true</code> if a component with the specified ID is registered;
   *         <code>false</code> otherwise.
   */
  public boolean isRegistered(String componentID){

    if(components.keySet().contains(componentID)){
      return true;
    }
    
    return false;
  }
  
  /**
   * 
   * @return How many components are registered.
   */
  public int size(){
    return components.size();
  }
  
  /**
   * Builds a list of the registered components.
   */
  public String toString(){
    
    String s = "Registered components: \n";

    for(Class c: components.values()){
      AComponentInfo ci = (AComponentInfo)c.getAnnotation(AComponentInfo.class);
      
      s = s + "  Component id = " + ci.id() + "\n";
      s = s + "  Component version = " + ci.version() + "\n";
      s = s + "  Component name = " + ci.name() + "\n";
      s = s + "  Component description = " + ci.description() + "\n";
      s = s + "\n";
    }
    
    return s;
  }
  
  
  
  private void callPrimitiveParameterInitializer(Class component, Object instance, String name, String value) throws InvocationTargetException,
                                                                                                                     IllegalAccessException{
    for(Method m: component.getMethods()){
      AParameterInitializer pi = m.getAnnotation(AParameterInitializer.class);
      
      if(pi != null){
        //  If we have found the component parameter we wanted
        if(pi.name().equals(name)){
        
          // Setup method parameters
          Object[] values = new Object[1];
          
          Class[] pTypes = m.getParameterTypes();
          
          // Cast parameter to the appropriate type
          if(pTypes[0] == String.class){
            values[0] = value;
          }
          else if(pTypes[0] == Double.TYPE){
            values[0] = Double.valueOf(value);
          }
          else if(pTypes[0] == Integer.TYPE){
            values[0] = Integer.valueOf(value);
          }
          else if(pTypes[0] == Boolean.TYPE){
              values[0] = Boolean.valueOf(value);
          }
          
          // TODO More types?
          
        
          // Call the method
          m.invoke(instance, values);
        
          // We are done
          break;
        }
      }
    }
  }
  
 
  
  private void callListParameterInitializer(Class component, Object instance, String name, List<String> value) throws InvocationTargetException,
                                                                                                                     IllegalAccessException{
    for(Method m: component.getMethods()){
      AParameterInitializer pi = m.getAnnotation(AParameterInitializer.class);
      
      if(pi != null){
        //  If we have found the component parameter we wanted
        if(pi.name().equals(name)){
        
          // Setup method parameters
          Object[] values = new Object[1];
          
          Type[] pTypes = m.getParameterTypes();
          
          // If the list is typed (i.e., using generics)
          if(pTypes[0] instanceof ParameterizedType){
            
            // If we are here, then we have a List<SomeType>
            //
            // Now, get the class of the list parameter (i.e., SomeType)
            ParameterizedType ppt = (ParameterizedType) pTypes[0];
            Type[] aTypes = ppt.getActualTypeArguments();
            Class listParameterType = aTypes[0].getClass();
            
            
            //  Cast the list elements to the appropriate type.
            if(listParameterType == String.class){
              List<String> list = new LinkedList<String>();
              for(String s: value){
                list.add(s);
              }
              m.invoke(instance, list);
            }
            else if(listParameterType == Double.class){
              List<Double> list = new LinkedList<Double>();
              for(String s: value){
                list.add(Double.valueOf(s));
              }
              m.invoke(instance, list);
            }
            else if(listParameterType == Integer.class){
              List<Integer> list = new LinkedList<Integer>();
              for(String s: value){
                list.add(Integer.valueOf(s));
              }
              m.invoke(instance, list);
            }
            else if(listParameterType == Boolean.class){
              List<Boolean> list = new LinkedList<Boolean>();
              for(String s: value){
                list.add(Boolean.valueOf(s));
              }
              m.invoke(instance, list);
            }
            
          }
          
          // Else, it is just a list of objects
          else{
            List<String> list = new LinkedList<String>();
            for(String s: value){
              list.add(s);
            }
            m.invoke(instance, list);  
          }
        
          // We are done
          break;
        }
      }
    }
  }
  
  // TODO callers for other types of parameter initializers (maps)
}
