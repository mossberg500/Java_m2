package homework1102;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client implements Runnable {

    private Socket socket;
    private String answer;
    private Thread thread;

    public Client(Socket socket, String answer) {
        this.socket = socket;
        this.answer = answer;
        this.thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try (InputStream in = socket.getInputStream(); OutputStream out = socket.getOutputStream()) {
            PrintWriter printWriter = new PrintWriter(out);
            byte[] request = new byte[in.available()];
            in.read(request);
            String response = "HTTP/1.1 200 OK\r\n" + "Server: My_Server\r\n" + "Content-Type: text/html\r\n" + "Content-Length: " + "\r\n" + "Connection: close\r\n\r\n";
            printWriter.print(response + answer);
            printWriter.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}