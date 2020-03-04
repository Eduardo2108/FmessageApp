package extraclase.conectivity;

import java.io.IOException;
import java.util.Arrays;

import static javafx.application.Application.launch;

public class App {

    private server listener = new server();
    private Client sender = new Client();
    private int puertoActual;
    private String ID;
    private static Conversacion[] listaConversaciones = server.listaConversaciones;

    public App(int puerto, String name){
        this.puertoActual = puerto;
        this.ID = name;
    }

    public void sendMessage(String mensaje, int puertoDestino, String nombreDestinatario) throws IOException {
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
    @Override
    public void start() {
        this.listener.start();

    }

}
