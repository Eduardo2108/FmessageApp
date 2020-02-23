package FmessageApp.conectivity;

import FmessageApp.conectivity.lista.Lista;

public class messages {

    private server receptor = new server();
    private client enviador = new client();
    private int puerto;
    private Lista mensajes;
    private String nombreRemitente;


    public messages(int port, String nombreRemitente, String mensaje, String hora){
        this.mensajes = new Lista(nombreRemitente);
        this.mensajes.agregarMensaje(mensaje,port,hora);

    }

}
