package teste;

import java.io.IOException;
import java.util.List;

import alevos.simulation.InvalidSimulatorRequest;

import simulator.agent.IAgent;
import simulator.agent.stimuli.EnvironmentStimulus;
import simulator.components.ComponentInstantiationException;
import simulator.components.ComponentParameters;
import simulator.components.ComponentsRegistry;
import simulator.components.NoSuchStateInspectorException;
import simulator.components.StateInspectorHelper;
import simulator.engine.SimulationState;
import simulator.engine.alevos.EMMASSimulatorConnector;
import simulator.engine.runner.ExecutionMode;
import simulator.engine.runner.SimulationRunner;
import simulator.environment.IEnvironment;
import simulator.io.ScenarioLoadingException;
import simulator.io.XMLScenarioLoader;
import simulator.io.esl.XMLESLLoader;
import simulator.ui.Messenger;
import simulator.ui.SimulatorUI;

public class Main {

	/** 
	 * @param args
	 * @throws ComponentInstantiationException 
	 * @throws NoSuchStateInspectorException 
	 * @throws ScenarioLoadingException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 * @throws InvalidSimulatorRequest 
	 */
	public static void main(String[] args) throws ComponentInstantiationException, NoSuchStateInspectorException, ScenarioLoadingException, IOException, ClassNotFoundException, InvalidSimulatorRequest {
		// TODO Auto-generated method stub
		System.out.println("++Inicio Teste++"); 
		/*  
		ComponentParameters cp = new ComponentParameters("organism.OrganismComponent");
		IEnvironment ie = new IEnvironment() {
			
			@Override
			public void step(ExecutionMode mode) {
				// TODO Auto-generated method stub
				
			} 
			
			@Override
			public void setSimulationState(SimulationState state) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public List<IAgent> getAgents() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public IAgent getAgent(int id) {
				// TODO Auto-generated method stub
				return null;
			}
		}; 
		ComponentsRegistry cr = new ComponentsRegistry();
		StateInspectorHelper sh = new StateInspectorHelper();
		IAgent ag = new IAgent() {
			
			@Override
			public void receiveStimulus(EnvironmentStimulus environmentStimulus) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getId() {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		sh.inspect(null, null);
		cr.createAgentControl(cp, ie); 
		cr.createProperty(cp, ie);
		cr.registerComponent(null);
		StateInspectorHelper si = new StateInspectorHelper();
		si.inspect(null, null);
		SimulationState sm = new SimulationState(0, null, null, null, null, null);
		sm.clone();
		Messenger messenger = new Messenger() {
			
			@Override
			protected void printMsg(String msg) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			protected void printDebugMsg(String msg) {
				// TODO Auto-generated method stub
				
			}
		};
		
		SimulatorUI.initialize(messenger);
		XMLScenarioLoader sl = new XMLScenarioLoader(cr);
		sl.loadScenario(null);
		simulator.io.esl.XMLESLLoader xm = new simulator.io.esl.XMLESLLoader(cr);
		xm.readEMMAS(null, null); 
		SimulationRunner sr = new SimulationRunner(null);
		simulator.engine.alevos.EMMASSimulatorConnector emma = new simulator.engine.alevos.EMMASSimulatorConnector(sr);
		emma.reset();
		emma.setup();*/
		EMMASSimulatorConnector ems = new EMMASSimulatorConnector(null);
		//ems.step();
		ems.setup();
	}

}
