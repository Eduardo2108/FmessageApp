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

public class server{
    private boolean flag = false;
    private ServerSocket receptorMensajes = null;
    private Conversacion[] listaConversaciones = new Conversacion[5];




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

    private void procesarEntrada(String entrada) {
        String[] datos = entrada.split("#");

        String remitente = datos[2];
        Date hora = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        String strHora = dateFormat.format(hora);
        // mensaje + puerto del remitente + hora actual
        this.agregarMensaje(datos[0], remitente, strHora);

    }

    private void agregarMensaje( String mensaje, String remitente, String hora){
        int index = 0;
        if(this.listaConversaciones[4]!=null){
             out.println("La lista de conversaciones esta llena");
             return;
        }

        while(index  < 5) {

            if (this.listaConversaciones[index] == null) {
                this.listaConversaciones[index] = new Conversacion();
                this.listaConversaciones[index].recibirMensaje(remitente, mensaje, hora);
                //out.println("Se crea una nueva conversacion con: " + remitente+ " mensaje: "+ mensaje + " en la posicion " + index  + "(" + this.listaConversaciones[index].cantidadMensajes + ")" );

                break;


            } else {


                if (this.listaConversaciones[index].getRemitente().equals(remitente)) {
                    this.listaConversaciones[index].recibirMensaje(remitente, mensaje, hora);
                    //out.println("Se agrega mensaje recibido: " + mensaje + " a la conversacion con: " + remitente + " en la posicion " + index +"(" + this.listaConversaciones[index].cantidadMensajes+")" );
                    break;

                }

                index++;

            }
        }
    }
    public static void main(String[] args) throws IOException {
        server s = new server();
        s.connect(100, 101);
        s.listen();
    }
}
