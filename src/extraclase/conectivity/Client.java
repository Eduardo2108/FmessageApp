package extraclase.conectivity;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {

    public static void sendMessage(String message, int port, int actualPort, String remitente) throws IOException {
        try {
            Socket client = new Socket("127.0.0.1", port);
            OutputStreamWriter writer = new OutputStreamWriter(client.getOutputStream());
            writer.write(message + "#" + actualPort + "#" + remitente + "\n");
            writer.flush();
            client.close();
        } catch (java.net.ConnectException e) {

            System.out.println("Error al conectar con el Puerto " + port);

        }
    }


}


