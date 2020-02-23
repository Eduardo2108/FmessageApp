package FmessageApp.conectivity;

import FmessageApp.conectivity.lista.Lista;

public class Conversacion {

    private Lista mensajes;
    private client enviador;
    private String nombreRemitente;
    private int cantMensajes;
    private int puerto;
    private int cantidadMensajes = 0;


    public void recibirMensaje(int port, String nombreRemitente, String mensaje, String hora) {

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