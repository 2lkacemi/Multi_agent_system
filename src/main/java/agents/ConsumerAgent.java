package agents;

import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;

public class ConsumerAgent extends Agent {

    @Override
    protected void setup(){
        System.out.println("*****************");
        System.out.println("Agent Initialisation ... "+ this.getAID().getName());
        if (this.getArguments().length==1){
            System.out.println("Je vais tenter d'acheter le livre "+ getArguments()[0]);
        }
        System.out.println("*****************");

        ParallelBehaviour parallelBehaviour = new ParallelBehaviour();
        addBehaviour(parallelBehaviour);

        parallelBehaviour.addSubBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage aclMessage = receive();
                if (aclMessage != null) {
                    System.out.println("****************");
                    System.out.println("Réception du message");
                    System.out.println(aclMessage.getContent());
                    System.out.println(aclMessage.getSender().getName());
                    System.out.println(aclMessage.getPerformative());
                    System.out.println(aclMessage.getLanguage());
                    System.out.println(aclMessage.getOntology());

                    ACLMessage reply = aclMessage.createReply();
                    reply.setContent("weekend libre ou non");
                    send(reply);
                }
                else {
                    block();
                }

            }
        });
    }

    @Override
    protected void beforeMove() {
        System.out.println("***************");
        System.out.println("Avant migration ..."+this.getAID().getName());
        System.out.println("*******************");
    }

    @Override
    protected void afterMove() {
        System.out.println("***************");
        System.out.println("Aprés migration ..."+this.getAID().getName());
        System.out.println("*******************");
    }

    @Override
    protected void takeDown() {
        System.out.println("***************");
        System.out.println("I'm going to die ..."+this.getAID().getName());
        System.out.println("*******************");
    }
}
