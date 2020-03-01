package extraclase.conectivity;


import extraclase.conectivity.ListaMensajes.ListaMensajes;
import extraclase.conectivity.ListaMensajes.Mensaje;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.net.ServerSocket;
import java.net.Socket;

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
        int puerto = Integer.parseInt(datos[1]);
        String remitente = datos[2];
        //out.println("EL mensaje fue: " + datos[0]);
        //out.println("El puerto fue: " + puerto);
        this.agregarMensaje(remitente, datos[0], "15:30");

    }

    private void agregarMensaje(String remitente, String mensaje, String hora){
        int index = 0;
        if(this.listaConversaciones[4]!=null){
            index = 4;
            out.println("La lista de conversaciones");
        }

        while(index != 4) {
            if (this.listaConversaciones[index] == null) {
                this.listaConversaciones[index] = new Conversacion();
                this.listaConversaciones[index].recibirMensaje(remitente, mensaje, hora);
                out.println("Se agrega mensaje recibido: " + mensaje + " a la conversacion con: " + remitente);
                break;


            } else {


                if (this.listaConversaciones[index].getRemitente().equals(remitente)) {
                    this.listaConversaciones[index].recibirMensaje(remitente, mensaje, hora);
                    out.println("Se crea una nueva conversacion con: " + remitente+ " mensaje: "+ mensaje  );
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
