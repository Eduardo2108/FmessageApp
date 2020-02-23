package FmessageApp.conectivity;

import FmessageApp.conectivity.lista.Lista;

public class Messenger {

    private server receptor = new server();
    private client enviador = new client();
    private Lista listaMensajes;
    private Lista mensajes;
    private String nombreRemitente;
    private int cantidadMensajes = 0;

    public void agregarMensaje(int port, String nombreRemitente, String mensaje, String hora) {
        if(cantidadMensajes == 0){
            mensajes = new Lista(nombreRemitente);
            mensajes.agregarMensaje(mensaje,port,hora);
            this.cantidadMensajes ++;
        }
        else{
            mensajes.agregarMensaje(mensaje,port,hora);
            this.cantidadMensajes ++;

        }
    }

}