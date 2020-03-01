package extraclase.conectivity;

import extraclase.conectivity.historial.ListaMensajes;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Conversacion {

    private ListaMensajes mensajes;
    private Client enviador;

    private String nombreRemitente; //Nombre de la otra persona
    private int puertoRemitente; // Puerto de la otra persona

    private int cantidadMensajes = 0;

    public Conversacion(int puertoRemitente) {
        enviador = new Client();
        this.puertoRemitente = puertoRemitente;
    }

    public void addMessage(String nombreRemitente, String mensaje, String hora, int key) {

        if (cantidadMensajes == 0) {
            this.nombreRemitente = nombreRemitente;
            this.enviador = new Client();
            mensajes = new ListaMensajes( );
            mensajes.agregarMensaje(mensaje, hora, key);
            this.cantidadMensajes++;
        } else {
            mensajes.agregarMensaje(mensaje, hora, key);
            this.cantidadMensajes++;

        }
    }


    public void sendMessage(String mensaje, int puerto, String id) throws IOException {

        enviador.sendMessage(mensaje, puertoRemitente, puerto, id);

        //Obtener la hora
        Date hora = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        String strHora = dateFormat.format(hora);
        this.addMessage(nombreRemitente, mensaje, strHora, 1);

    }

    public String getRemitente() {
        return this.nombreRemitente;
    }

    public int getPuerto() {
        return this.puertoRemitente;
    }
}