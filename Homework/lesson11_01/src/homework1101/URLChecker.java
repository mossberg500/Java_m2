package homework1101;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;

public class URLChecker {
  private String path;
    private HashMap<String, String> urlMap;

    public URLChecker() {
    super();
    }
    public URLChecker(String path) {
        this.path = path;
    }

    public void check() {
        HashMap<String, String> map = readURL();
        Set<String> keys = map.keySet();

        keys.forEach((s)->{
            System.out.println(s + " - " + map.get(s));
        });

    }

    public String checkURL(String urlAdress) {
        try {
            URL url = new URL(urlAdress);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            int responseCode = connection.getResponseCode();
            if (responseCode >= 200 && responseCode < 300) {
                return "Accessible";
            } else {
                return "Inaccessible " + connection.getResponseMessage();
            }
        } catch (IOException ex) {
            System.out.println( "URL " + urlAdress + " Inaccessible ");
        }
        return "Inaccessible - URL  ";
    }

    public HashMap<String, String> readURL() {
        urlMap = new HashMap<>();
        String line = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while ((line = reader.readLine()) != null) {
                urlMap.put(line, checkURL(line));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return urlMap;
    }

}