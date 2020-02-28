package FmessageApp.conectivity;

import FmessageApp.conectivity.ListaMensajes.ListaMensajes;

public class Conversacion {

    private ListaMensajes mensajes;
    private client enviador = new client();
    private String nombreRemitente;
    private int cantidadMensajes = 0;
    private int puerto;

    public Conversacion(String Remitente, int puertoRemitente){
        this.nombreRemitente = Remitente;
        this.puerto = puertoRemitente;
    }


    public void recibirMensaje(String nombreRemitente, String mensaje, String hora) {

        if(cantidadMensajes == 0){
            this.nombreRemitente = nombreRemitente;
            mensajes = new ListaMensajes(nombreRemitente);
            mensajes.agregarMensaje(mensaje,hora);
            this.cantidadMensajes ++;
        }
        else{
            mensajes.agregarMensaje(mensaje,hora);
            this.cantidadMensajes ++;

        }
    }
    public void enviarMensaje(){

    }
    public static void main(String[] args) {
    }

}