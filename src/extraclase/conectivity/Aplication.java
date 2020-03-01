package extraclase.conectivity;

import extraclase.conectivity.Client;
import extraclase.conectivity.server;

import java.io.IOException;

public class Aplication {

    private server listener;
    private Client sender;
    private int puertoActual;
    private String ID;
    private Conversacion[] listaConversaciones = server.listaConversaciones;

    private void sendMessage(String mensaje, int puerto, String nombreDestinatario) throws IOException {
        int i = 0;
        boolean flag = true;
        while (i < 5 && flag) {
            if (listaConversaciones[i].getRemitente().equals(nombreDestinatario)) {
                listaConversaciones[i].sendMessage(mensaje, puerto, ID);
                flag = false;
            } else {
                if (listaConversaciones[i] == null) {
                    listaConversaciones[i] = new Conversacion(puerto);
                    listaConversaciones[i].sendMessage(mensaje, puerto, ID);
                }
            }
            i++;
        }
    }





}
