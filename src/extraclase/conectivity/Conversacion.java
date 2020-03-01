package extraclase.conectivity;

import extraclase.conectivity.ListaMensajes.ListaMensajes;

public class Conversacion {

    private ListaMensajes mensajes;
    private Client enviador;
    private String nombreRemitente;
    private int cantidadMensajes = 0;


    public void recibirMensaje(String nombreRemitente, String mensaje, String hora) {

        if(cantidadMensajes == 0){
            this.nombreRemitente = nombreRemitente;
            this.enviador = new Client();

            mensajes = new ListaMensajes(nombreRemitente);
            mensajes.agregarMensaje(mensaje,hora);
            this.cantidadMensajes ++;
        }
        else{
            mensajes.agregarMensaje(mensaje,hora);
            this.cantidadMensajes ++;

        }
    }
    public String getRemitente(){
        return this.nombreRemitente;
    }
    public static void main(String[] args) {

    }

}