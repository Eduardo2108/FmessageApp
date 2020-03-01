package extraclase.conectivity;

import extraclase.conectivity.Client;
import extraclase.conectivity.server;
import javafx.application.Application;

import java.io.IOException;

public class Aplication {

    private server listener = new server();
    private Client sender;
    private int puertoActual;
    private String ID;
    private Conversacion[] listaConversaciones = server.listaConversaciones;

    private void sendMessage(String mensaje, int puertoDestino, String nombreDestinatario) throws IOException {
        int i = 0;
        boolean flag = true;

        while (i < 5 && flag) {
            if (listaConversaciones[i].getRemitente().equals(nombreDestinatario)) {
                listaConversaciones[i].sendMessage(mensaje, puertoDestino, ID);
                flag = false;
            } else {
                if (listaConversaciones[i] == null) {
                    listaConversaciones[i] = new Conversacion(puertoDestino);
                    listaConversaciones[i].sendMessage(mensaje, puertoDestino, ID);
                }
            }
            i++;
        }
    }
    private void start() {
        this.listener.start();

    }

    public static void main(String[] args) {
        Aplication app = new Aplication();
         app.start();
    }

}
