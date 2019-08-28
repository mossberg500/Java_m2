package homework1103;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Searcher {
    private String urlAdress;

    public Searcher() {
        super();
    }

    public Searcher(String urlAdress) {
        this.urlAdress = urlAdress;
    }

    public void writeLiksToFile() {
        List<String> links = parsPage();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("folderOne\\Links.txt")))) {
            if (!links.isEmpty()) {
                links.forEach((s) -> {
                    try {
                        writer.write(s + "\n");
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                });
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public HttpURLConnection connect() {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(urlAdress);
            connection = (HttpURLConnection) url.openConnection();
            return connection;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return connection;
    }

    public List<String> parsPage() {
        ArrayList<String> links = new ArrayList<String>();
        HttpURLConnection connection = connect();
        String httpcontent = getContent(connection);
        String regex = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        Pattern linkPattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher pageMatcher = linkPattern.matcher(httpcontent);
        while (pageMatcher.find()) {
            links.add(pageMatcher.group());
        }
        return links;
    }

    public String getContent(HttpURLConnection connection) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                builder.append(line).append(System.lineSeparator());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return builder.toString();
    }
}