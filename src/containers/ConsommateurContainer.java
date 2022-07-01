package containers;

import agents.AcheteurAgent;
import agents.ConsommateurAgent;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;

public class ConsommateurContainer {
	public ConsommateurContainer() {
	    Runtime runtime = Runtime.instance();
		ProfileImpl profilImp = new ProfileImpl(false);
		profilImp.setParameter(ProfileImpl.MAIN_HOST, "localhost");
		profilImp.setParameter(ProfileImpl.CONTAINER_NAME, "Consommateurs");
		AgentContainer agentContainer = runtime.createAgentContainer(profilImp);
		try {
			AgentController agentController1 = agentContainer.createNewAgent("Consommateur1", ConsommateurAgent.class.getName(), new Object[]{"XML"});

			agentController1.start();
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

}
