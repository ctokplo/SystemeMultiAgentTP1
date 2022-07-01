package agents;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

public class ConsommateurAgent extends Agent {
    @Override
    protected void setup() {
        String name = this.getAID().getLocalName();
        System.out.println("Consommateur  : "+ name + " créé");

        Object [] args = getArguments();
        if(args.length==0){
            doDelete();
        }else {
            System.out.println("Tentative d'achat du livre " + args[0]);

            // Envoie de la requête à l'acheteur 1
            ACLMessage message = new ACLMessage(ACLMessage.REQUEST);
            message.addReceiver(new AID("Acheteur1", AID.ISLOCALNAME));
            message.setContent(args[0]+"");
            send(message);
        }

        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage message = receive();
                if (message != null){
                    System.out.println(name+" : "+message.getContent());
                }
                else{
                    block();
                }
            }
        });
    }

}
