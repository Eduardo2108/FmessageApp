package extraclase.conectivity;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.lang.System.*;

/**
 * Esta clase se encarga de recibir los mensajes entrantes y procesarlos y pasarlos a la clase Conversacion segun corresponda
 */
public class server  {
    private boolean flag = false;
    private ServerSocket receptorMensajes = null;
    private Conversacion[] listaConversaciones = new Conversacion[5];
    private int min = 100, max = 110;


    /**
     * @param min margen minimo del rango de puertos en los que se quiere probar conexion
     * @param max margen maximo del rando de puertos en los que se quiere probar conexion
     */
    public void connect(int min, int max) {
        while (!flag && min != max) {
            try {
                receptorMensajes = new ServerSocket(min);
                out.println("server conectado al puerto: " + min);
                flag = true;
            } catch (IOException e) {
                e.printStackTrace();
                min++;

            }

        }
    }

    /**
     * Metodo que inicia la escucha del puerto conectado para recibir mensajes
     *
     * @throws IOException
     */
    public void listen() throws IOException {
        boolean active = true;
        while (active) {
            out.println("listening...");
            Socket entrada = receptorMensajes.accept();
            BufferedReader lector = new BufferedReader(new InputStreamReader(entrada.getInputStream()));
            String mensaje = lector.readLine();
            procesarEntrada(mensaje);
            entrada.close();

        }
    }

    /**
     * Descompone el mensaje siguiendo la siguiente formula: mensaje +
     *
     * @param entrada: el mensaje recibido del puerto
     */
    private void procesarEntrada(String entrada) {
        String[] datos = entrada.split("#");

        String mensaje = datos[0];
        int puertoRemitente = Integer.parseInt(datos[1]);
        String remitente = datos[2];
        //Obtener la hora
        Date hora = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        String strHora = dateFormat.format(hora);

        // mensaje + puerto del remitente + hora actual
        this.agregarMensaje(mensaje, remitente, strHora, puertoRemitente);

    }

    private void agregarMensaje(String mensaje, String remitente, String hora, int puertoRemitente) {
        int index = 0;
        boolean flag = true;
        if (this.listaConversaciones[4] != null) {
            out.println("La lista de conversaciones esta llena");
            return;
        }

        while (index < 5 && flag) {

            if (this.listaConversaciones[index] == null) {
                /**
                 * Se crea una instancia nueva de la conversacion en el array
                 */
                this.listaConversaciones[index] = new Conversacion(puertoRemitente);
                this.listaConversaciones[index].recibirMensaje(remitente, mensaje, hora);
                 flag= false;


            } else {
                /**
                 * Se carga el mensaje en una instancia ya existente de la Conversacion
                 */
                if (this.listaConversaciones[index].getRemitente().equals(remitente)) {
                    this.listaConversaciones[index].recibirMensaje(remitente, mensaje, hora);
                    flag= false;

                }

                index++;

            }
        }
    }

    public static void main(String[] args) throws IOException {
        server s = new server();
        s.connect(s.min,s.max);
        s.listen();
    }
}
