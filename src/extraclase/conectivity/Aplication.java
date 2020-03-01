package extraclase.conectivity;

import extraclase.conectivity.Client;
import extraclase.conectivity.server;

import java.io.IOException;

public class Aplication {

    private server listener;
    private Client sender;
    private int puertoActual;
    private String ID;

    private void sendMessage(String mensaje, int puerto) throws IOException {
        sender.sendMessage(mensaje,puerto,puertoActual,ID);
        System.out.println("Mensaje enviado a: ");
    }
}
