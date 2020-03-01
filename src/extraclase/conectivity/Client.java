package extraclase.conectivity;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {

    public void sendMessage(String message, int port, int actualPort, String remitente) throws IOException {

        Socket client = new Socket("127.0.0.1", port);
        OutputStreamWriter writer = new OutputStreamWriter(client.getOutputStream());
        writer.write(message + "#" + actualPort + "#" + remitente + "\n");
        writer.flush();
        client.close();
    }

    public static void main(String[] args) throws IOException {
        Client m = new Client();

        m.sendMessage("Hola mundo x2", 100, 50, "Eduardo");
        m.sendMessage("Hola mundo x2", 100, 50, "Eduardo");
        m.sendMessage("Hola mundo x2", 100, 50, "Eduardo");
        m.sendMessage("Hola mundo x2", 100, 50, "Eduardo");
       // m.sendMessage("Hola mundo x2", 100, 50, "Ricardo");
        //m.sendMessage("Hola mundo x2", 100, 50, "Juan");
        m.sendMessage("Hola mundo x2", 100, 50, "Eduardo");
        //m.sendMessage("Hola mundo x2", 100, 50, "Juan");
    }
}

