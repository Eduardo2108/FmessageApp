package FmessageApp.conectivity;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class client {
    public static void send_message(String message, int port, int actualPort) throws IOException {
        Socket client = new Socket("127.0.0.1",port);
        OutputStreamWriter writer = new OutputStreamWriter(client.getOutputStream());
        writer.write(message + "#" + actualPort);
        writer.flush();
        client.close();
    }

    public static void main(String[] args) throws IOException {
        client c = new client();
        c.send_message("Testing", 100, 1010);
    }
}


