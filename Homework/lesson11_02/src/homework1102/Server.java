package homework1102;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private int index = 1;

    public Server() {

    }

    public void showParameters() {
        try (ServerSocket socket = new ServerSocket(8080)) {
            while (true) {
                Socket clSocket = socket.accept();
                Client client = new Client(clSocket, getAnswer(index));
                index++;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public List<String> getParameters() {
        Runtime runtime = Runtime.getRuntime();
        List<String> parameters = new ArrayList<>();
        parameters.add("Processors: " + runtime.availableProcessors());
        parameters.add("Free memory: " + runtime.freeMemory());
        parameters.add("Total memory: " + runtime.totalMemory());
        parameters.add("OS  " + System.getProperty("os.name"));
        parameters.add("os.version  " + System.getProperty("os.version"));
        parameters.add("user.name  " + System.getProperty("user.name"));
        parameters.add("user.home " + System.getProperty("user.home"));
        parameters.add("user.dir " + System.getProperty("user.dir"));
        parameters.add("java.version " + System.getProperty("java.version"));
        parameters.add("java.home " + System.getProperty("java.home"));
        return parameters;
    }

    public String getAnswer(int index) {
        String answer = "";
        List<String> parameters = getParameters();
        answer += "<html><head><title>Computer</title><meta charset='utf-8'></head><body><p>My computer parameters" + index;
        answer += "<table border='2' cellpadding='5'><tr><th>Parameters</th></tr>";
        for (String parameter : parameters) {
            answer += "<tr><td>" + parameter + "</td></tr>";
        }
        answer += "</table></body></html>";
        index++;
        return answer;
    }
}