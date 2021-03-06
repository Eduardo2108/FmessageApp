package extraclase.conectivity;

import extraclase.conectivity.historial.ListaMensajes;

import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Conversacion {

    private ListaMensajes mensajes;
    private Client enviador;

    private String nombreDestinatario; //Nombre de la otra persona
    private int puertoDestino; // Puerto de la otra persona

    private int cantidadMensajes = 0;

    public Conversacion(int puertoDestino) {
        enviador = new Client();
        this.puertoDestino = puertoDestino;
        System.out.println("Nueva conversacion con el puerto: " + this.puertoDestino);

        System.out.println(Arrays.toString(server.listaConversaciones));
    }

    public void addMessage(String nombreDestinatario, String mensaje, String hora, int key) {

        if (cantidadMensajes == 0) {
            this.nombreDestinatario = nombreDestinatario;
            this.enviador = new Client();
            mensajes = new ListaMensajes( );
            mensajes.agregarMensaje(mensaje, hora, key);
            this.cantidadMensajes++;

            String tipo = "Enviado";
            if(key == 2){
                tipo = "Recibido";
            }
            System.out.println("Mensaje " + tipo + " a las: " + hora + ", Mensaje: " + mensaje);

        } else {
            mensajes.agregarMensaje(mensaje, hora, key);
            this.cantidadMensajes++;

        }
    }


    public void sendMessage(String mensaje, int puerto, String id) throws IOException {

        enviador.sendMessage(mensaje, puertoDestino, puerto, id);

        //Obtener la hora
        Date hora = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        String strHora = dateFormat.format(hora);
        this.addMessage(nombreDestinatario, mensaje, strHora, 1);

    }

    public String getRemitente() {
        return this.nombreDestinatario;
    }

    public int getPuerto() {
        return this.puertoDestino;
    }

    public static void main(String[] args) throws IOException {
        Conversacion c = new Conversacion(100);
        c.sendMessage("Hola mimigo", 100, "E$");

    }
}
