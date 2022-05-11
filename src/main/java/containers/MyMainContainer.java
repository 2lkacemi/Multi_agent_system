package containers;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.ControllerException;

public class MyMainContainer {
    public static void main(String[] args) throws ControllerException {
        //on crée une instance de Runtime(instanciation de JADE)
        Runtime runtime = Runtime.instance();

        //ProfileImpl ,ous permet de paramétré le container
        ProfileImpl profileImpl = new ProfileImpl();
        profileImpl.setParameter(ProfileImpl.GUI, "true");

        //on démarre le container
        AgentContainer mainContainer = runtime.createMainContainer(profileImpl);
        mainContainer.start();



    }
}
