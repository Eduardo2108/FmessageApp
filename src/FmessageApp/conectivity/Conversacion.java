package FmessageApp.conectivity;

import FmessageApp.conectivity.ListaMensajes.ListaMensajes;

public class Conversacion {

    private ListaMensajes mensajes;
    private client enviador;
    private String nombreRemitente;
    private int cantidadMensajes = 0;


    public void recibirMensaje(String nombreRemitente, String mensaje, String hora) {

        if(cantidadMensajes == 0){
            this.nombreRemitente = nombreRemitente;
            this.enviador = new client();

            mensajes = new ListaMensajes(nombreRemitente);
            mensajes.agregarMensaje(mensaje,hora);
            this.cantidadMensajes ++;
        }
        else{
            mensajes.agregarMensaje(mensaje,hora);
            this.cantidadMensajes ++;

        }
    }
    public static void main(String[] args) {
        Conversacion primera = new Conversacion();
        primera.recibirMensaje("Eduardo", "Hola mundo", "13:50");

    }

}