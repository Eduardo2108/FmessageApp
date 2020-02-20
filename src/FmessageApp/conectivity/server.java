package FmessageApp.conectivity;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    private boolean flag = false;
    private boolean active = true;
    private ServerSocket server = null;
    public void connect(int min, int max){
        while(!flag & min!=max){
            try{
                server = new ServerSocket(min);
                System.out.println("server conectado al puerto: " + min);
                flag = true;
            } catch (IOException e) {
                e.printStackTrace();
                min++;

            }

        }
    }

    public void listen() throws IOException {
        while(true){
            System.out.println("listening...");
            Socket entrada = server.accept();
            BufferedReader lector = new BufferedReader(new InputStreamReader(entrada.getInputStream()));
            String mensaje = lector.readLine();
            System.out.println(mensaje);
            entrada.close();

        }
    }

    public static void main(String[] args) throws IOException {
        server s = new server();
        s.connect(100, 101);
        s.listen();
    }
}
