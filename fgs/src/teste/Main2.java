/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

/**
 *
 * @author alexandre
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

import java.util.List;
import javax.swing.JFrame;

import alevos.simulation.InvalidSimulatorRequest;

import simulator.ArgumentsParser;
import simulator.InvalidArgumentException;
import simulator.Simulator;
import simulator.agent.IAgent;
import simulator.analysis.UndefinedPropertyException;
import simulator.components.ComponentInstantiationException;
import simulator.components.ComponentParameters;
import simulator.components.ComponentsRegistry;
import simulator.components.NoSuchStateInspectorException;
import simulator.engine.SimulationState;
import simulator.engine.runner.ExecutionMode;
import simulator.engine.runner.SimulationRunException;
import simulator.environment.IEnvironment;
import simulator.environment.InvalidEnvironmentException;
import simulator.io.ExperimentLoadingException;
import simulator.io.ScenarioLoadingException;
import simulator.ui.CLMessenger;
import simulator.ui.Messenger;
import simulator.ui.SimulatorUI;
import simulator.ui.gui.SimulationWindow;

 

/**
 * @author   Paulo Salem
 */
public class Main2 {
  
  static final String VERSION = "0.2";

	static File output = new File("output.dat");
	static PrintWriter writer;

	static Simulator sim;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//alexandre 16/12/20011 8:41
		//quero verificar entrada args do sistema
		//motivo: os parametros de execucao devem ser passados para VM do JPF.
		args = new String[4];
		args[0] = "-s";
		args[1] = "/home/alexandre/workspace/fgs/simulador/EMMAS Dog/dog.emmas.scenario.xml";
		args[2] = "-e";
		args[3] = "/home/alexandre/workspace/fgs/simulador/EMMAS Dog/dog.simpurpverif.experiment.xml";
		//args[4] = "-max-depth 50 -max-synch-steps 600";
   
    try {
      
      //
      // Read parameters.
      //
      
      HashSet<String> possibleParameters = new HashSet<String>();
      possibleParameters.add("e");
      possibleParameters.add("s");
      possibleParameters.add("gui");
      possibleParameters.add("verbose");
      possibleParameters.add("debug");
      possibleParameters.add("max-depth");
      possibleParameters.add("dont-randomize");
      possibleParameters.add("max-synch-steps");
      possibleParameters.add("help");
      possibleParameters.add("version");
      
      ArgumentsParser ap = new ArgumentsParser(args, possibleParameters);
      
      
      //
      // Apply parameters.
      //
      
      // Show help information
      if(ap.isParameterSet("help")){
        printUsage();
        System.exit(0);
      }
      
      // Show version information
      if(ap.isParameterSet("version")){
        printVersion();
        System.exit(0);
      }

      // Enforce rules
      ap.enforceParameterAndValuePresence("e");
      ap.enforceParameterAndValuePresence("s");
      ap.enforceValuePresence("verbose");
      ap.enforceValuePresence("max-depth");
      ap.enforceValuePresence("max-synch-steps");

      
         
      // Use a GUI if requested...
      if(ap.isParameterSet("gui")){
        // TODO SimulatorUI.instance(new GUIMessenger());
        
        SimulationWindow frame = new SimulationWindow();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }
      // ... else, stay with the command line
      else{
        SimulatorUI.initialize(new CLMessenger());
      }
   
      // Welcome message
      SimulatorUI.instance().getMessenger().printMsg("FGS - Formally Guided Simulator", Messenger.IMPORTANT_MSG);
      SimulatorUI.instance().getMessenger().printMsg("Processing input...", Messenger.IMPORTANT_MSG);
  
      // Set verbose level
      if(ap.isParameterSet("verbose")){
        SimulatorUI.instance().getMessenger().setMinMsgImportance(Integer.parseInt(ap.getParameterValue("verbose")));
      }
      
      
      // Check debug options
      if(ap.isParameterSet("debug")){
        SimulatorUI.instance().getMessenger().setShowDebugMsgs(true);
      }
      else{
        SimulatorUI.instance().getMessenger().setShowDebugMsgs(false);
      }
      
      // Set maximum search depth
      if(ap.isParameterSet("max-depth")){
        Simulator.instance().setMaxDepth(Integer.parseInt(ap.getParameterValue("max-depth")));
      }
      SimulatorUI.instance().getMessenger().printMsg("Max. Search Depth: " + Simulator.instance().getMaxDepth(), Messenger.NORMAL_MSG);
      
      // Set randomization
      if(ap.isParameterSet("dont-randomize")){
        Simulator.instance().setRandomize(false);
      }
      else{
        Simulator.instance().setRandomize(true);
      }
      SimulatorUI.instance().getMessenger().printMsg("Randomize: " + Simulator.instance().getRandomize(), Messenger.NORMAL_MSG);

      
      // Set maximum number of synchronization steps
      if(ap.isParameterSet("max-synch-steps")){
        Simulator.instance().setMaxSynchSteps(Integer.parseInt(ap.getParameterValue("max-synch-steps")));
      }
      else{
        Simulator.instance().setMaxSynchSteps(null);
      }
      SimulatorUI.instance().getMessenger().printMsg("Max. Synch. Steps: " + Simulator.instance().getMaxSynchSteps(), Messenger.NORMAL_MSG);
        

      
      
     // 
     // Finally, run simulations
     //
     runFromFiles(new File(ap.getParameterValue("s")), new File(ap.getParameterValue("e")));
     SimulatorUI.instance().getMessenger().printMsg("Finished.", Messenger.IMPORTANT_MSG);
      
    } catch (InvalidArgumentException e) {
      // Use standard output here, since our UI might not have been initialized
      System.out.println("Error: Invalid parameters. " + e.getMessage());  
      printUsage();
    } catch (Exception e){
      
      // TODO provide a more friendly error treatment
      e.printStackTrace();
    }
    



	}


	/**
	 * Prints instructions on how to use the program.
	 *
	 */
	public static void printUsage(){
		System.out.println("Please specify the following parameters: \n");
		System.out.println("  -s scenario.xml     Defines the scenario to analyze.              (Mandatory)");
    System.out.println("  -e strategy.xml     Defines the experiment to perform.            (Mandatory)");
    System.out.println("  -verbose L          Requests messages of importance >= L to\n" +
    	               	 "                      be shown. L is an integer between 0 \n" +
    	               	 "                      (least important) and 4 (most important).\n" +
    	               	 "                      By default, verbose level is set to 2.        (Optional)");
    System.out.println("  -max-depth D        Defines the maximum depth allowed in any \n" +
    		               "                      search. D is a positive integer,              (Optional)");
    System.out.println("  -dont-randomize     Avoids randomizing non-deterministic choices,\n" +
                   		 "                      which is the default behaviour.               (Optional)");
    System.out.println("  -max-synch-steps S  Defines the maximum number of synchronizations\n" +
    		               "                      in algorithms based on synchronous products.\n" +
    		               "                      S is a positive integer. By default, there is\n" +
    		               "                      no such maximum limit.                        (Optional)");
    System.out.println("  -debug              Allows debug information to be shown.         (Optional)");
    System.out.println("  -version            Displays the version of this software and \n" +
    		               "                      related information.                          (Optional)");
    System.out.println("  -help               Displays this message.                        (Optional)");
	}
	
	public static void printVersion(){
	  System.out.println("FGS - Formally Guided Simulator");
	  System.out.println("Version " + VERSION);
	  System.out.println("By Paulo Salem da Silva (salem@ime.usp.br)\n");
    System.out.println("Copyright (c) 2008 - 2011 Paulo Salem da Silva");

	}


	/**
	 * Simulates the scenario described in the specified file according to the specified
   * strategy.
	 * 
	 * @param scenario The scenario's XML file.
   * @param experiment The experiment's XML file.
	 * @throws Exception 
	 */
	public static void runFromFiles(File scenario, File experiment) throws Exception{

			sim = Simulator.instance();

			sim.loadScenario(scenario);
            sim.loadExperiment(experiment);
			
			sim.runExperiment();
                        
                ComponentParameters cp = new ComponentParameters("organism.OrganismComponent");        
                IEnvironment ie = new IEnvironment() {

            @Override
            public void step(ExecutionMode mode) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public List<IAgent> getAgents() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public IAgent getAgent(int id) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void setSimulationState(SimulationState state) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
                ComponentsRegistry cr = new ComponentsRegistry();
	
		
		cp.addParameter("id", "Dog");
                cp.addParameter("name","Dog");
		try {
			cr.createAgentControl(cp, ie);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		cr.createProperty(cp, ie);

	}




}

