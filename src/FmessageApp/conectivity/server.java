package FmessageApp.conectivity;


import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.*;

public class server {
    private boolean flag = false;
    private ServerSocket receptorMensajes = null;
    private void connect(int min, int max){
        while(!flag && min!=max){
            try{
                receptorMensajes = new ServerSocket(min);
                out.println("server conectado al puerto: " + min);
                flag = true;
            } catch (IOException e) {
                e.printStackTrace();
                min++;

            }

        }
    }

    private void listen() throws IOException {
        boolean active = true;
        while(active){
            out.println("listening...");
            Socket entrada = receptorMensajes.accept();
            BufferedReader lector = new BufferedReader(new InputStreamReader(entrada.getInputStream()));
            String mensaje = lector.readLine();
            procesarEntrada(mensaje);
            entrada.close();

        }
    }

    private void procesarEntrada(String entrada){
         String[] datos = entrada.split("#");
        int puerto = Integer.parseInt(datos[1]);
        String remitente = datos[2];
        out.println("EL mensaje fue: " + datos[0]);
        out.println("El puerto fue: " + puerto);

        Conversacion primeraConversacion = new Conversacion(remitente, puerto);
        primeraConversacion.recibirMensaje(remitente,datos[0],"15:30");
    }
    public static void main(String[] args) throws IOException {
        server s = new server();
        s.connect(100, 101);
        s.listen();
    }
}
