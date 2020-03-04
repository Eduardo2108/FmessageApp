package extraclase.conectivity;

import extraclase.gui.ventanaChatController;

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
public class server {


    private boolean flag = false;
    private ServerSocket receptorMensajes = null;
    public static Conversacion[] listaConversaciones = new Conversacion[5];
    private int min = 100, max = 110;
    private int myPort;

    /**
     * @param min margen minimo del rango de puertos en los que se quiere probar conexion
     * @param max margen maximo del rando de puertos en los que se quiere probar conexion
     */
    public void connect(int min, int max) {
        while (!flag && min != max) {
            try {
                receptorMensajes = new ServerSocket(min);
                out.println("server conectado al puerto: " + min);
                this.myPort = min;
                flag = true;
            } catch (IOException e) {
                out.println(e);
                min++;

            }

        }
    }
    public void start(){
        this.connect(this.min, this.max);
        this.run();
    }
    public int getPort(){
        return myPort;
    }
    /**
     * Metodo que inicia la escucha del puerto conectado para recibir mensajes
     *
     * @throws IOException
     */


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

        //instancia para agregar mensajes o asi
        ventanaChatController v = new ventanaChatController();

    }

    private void agregarMensaje(String mensaje, String remitente, String hora, int puertoRemitente) {
        int index = 0;
        boolean flag = true;


        while (index < 5 && flag) {

            if (listaConversaciones[index] == null) {
                listaConversaciones[index] = new Conversacion(puertoRemitente);
                listaConversaciones[index].addMessage(remitente, mensaje, hora, 2);
                 flag= false;


            } else {

                 // Se carga el mensaje en una instancia ya existente de la Conversacion

                if (listaConversaciones[index].getRemitente().equals(remitente)) {
                    listaConversaciones[index].addMessage(remitente, mensaje, hora, 2);
                    flag= false;

                }

                index++;

            }
        }
    }

    public void run(){
       Thread t = new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   out.println("listening...");
                   boolean active = true;

                   while (active) {
                       Socket entrada = receptorMensajes.accept();
                       BufferedReader lector = new BufferedReader(new InputStreamReader(entrada.getInputStream()));
                       String mensaje = lector.readLine();
                       procesarEntrada(mensaje);
                       entrada.close();


                   }
               }
               catch (IOException a){
                   out.println(a.getMessage());
               }


           }
       });
       t.start();
    }


}
