package extraclase.conectivity;

import java.io.IOException;
import java.util.Arrays;

public class Aplication {

    private server listener = new server();
    private Client sender = new Client();
    private int puertoActual;
    private String ID;
    private static Conversacion[] listaConversaciones = server.listaConversaciones;
    private void sendMessage(String mensaje, int puertoDestino, String nombreDestinatario) throws IOException {
        int i = 0;
        boolean flag = true;
        System.out.println(Arrays.toString(listaConversaciones));

        while (i < 5 && flag) {
            Conversacion temp = listaConversaciones[i];
            if(temp == null){
                listaConversaciones[i] = new Conversacion(puertoDestino);
                listaConversaciones[i].sendMessage(mensaje,puertoDestino,this.ID);
                System.out.println("mensaje enviado, primer if");
                break;
            }
            else{
                if(temp.getPuerto() == puertoDestino){
                    listaConversaciones[i].sendMessage(mensaje,puertoDestino,this.ID);
                    System.out.println("Mensje enviado sengundo if");
                    break;

                }
                else{
                    System.out.println("Avanzando a el siguiente elemento");
                    i++;
                }
            }
        }
    }

    private void start() {
        this.listener.start();

    }

    public static void main(String[] args) throws IOException {

    }


}
