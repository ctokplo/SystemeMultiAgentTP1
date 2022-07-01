package agents;

import gui.MyFrame;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.gui.GuiAgent;
import jade.gui.GuiEvent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import javax.swing.*;

//public class AcheteurAgent extends Agent {
public class AcheteurAgent extends Agent {

//    MyFrame frame = new MyFrame();
/*
    @Override
    //la methode setup() s'execute une seule fois
    protected void setup() {

        addBehaviour(new Behaviour() {
            int i=0;
            @Override
            public void action() {
                System.out.println("Comportement générique");
              i++;
            }

            @Override
            public boolean done() {
               // return false;
                return i==10 ;
            }
        });
*/

//        frame.setTitle("Login Form");
//        frame.setVisible(true);
//        frame.setBounds(10, 10, 700, 700);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setResizable(true);
//
//        frame.setAcheteurAgent(this);

//        // TODO Auto-generated method stub
//        String name = this.getAID().getLocalName();
//        System.out.println("Agent Acheteur " + name + " crée");
//
//        Object[] args = getArguments();
//        if (args.length == 0) {
//            doDelete();
//        } else {
//            System.out.println("Tentative d'achat du livre" + args[0]);
//        }
//
//		/*
//
//		// Comportement Agent
//				addBehaviour(new OneShotBehaviour() {
//					public void action() {
//						// TODO Auto-generated method stub
//						System.out.println("Une seule execution");
//					}
//				});
//				*/
//		/*
//		//Execution cyclique
//		addBehaviour(new CyclicBehaviour() {
//			public void action() {
//				// TODO Auto-generated method stub
//				System.out.println("Execution cyclique");
//			}
//		});
//		*/
//
//
//        // Comportement Agent
//        addBehaviour(new TickerBehaviour(this, 5000) {
//            protected void onTick() {
//                // TODO Auto-generated method stub
//                System.out.println("Chaque cinq seconde");
//
//            }
//        });
//    }

//    @Override
//    //est appelé avant de supprimer l'agent
//    protected void takeDown() {
//        String name = this.getAID().getLocalName();
//        System.out.println("Destruction de l'Agent  " + name);
//
//    }

//    private SellingGui gui;

    @Override
    protected void setup() {
        String name = this.getAID().getLocalName();
        System.out.println("Acheteur  : "+ name + " créé");
        //Execution cyclique
        addBehaviour(new CyclicBehaviour() {
            public void action() {
                // TODO Auto-generated method stub
                MessageTemplate messageTemplate = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
                ACLMessage message = receive(messageTemplate);
                if(message!=null){
                    System.out.println(name + " : Réception de la demande d'achat du Livre " + message.getContent());
                    ACLMessage response = new ACLMessage(ACLMessage.INFORM);
                    response.addReceiver(message.getSender());
                    response.setContent("Demande d'Achat du Livre "+ message.getContent() + " Reçu avec Succès ");
                    send(response);
                }else{
                    block();
                }
            }
        });

    }



}
