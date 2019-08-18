package homework104;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class StringArt {

    private Map<Character, List<String>> charMap;
    private String filename;
    final private int heightArt = 9;

    public StringArt(String filename) {
        super();
        this.filename = filename;
        this.charMap = new TreeMap<>();
    }

    public void inicArt() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String str;
            while ((str = br.readLine()) != null) {
                char c = str.charAt(0);
                List<String> art = new ArrayList<>(heightArt);
                for (int i = 0; i < heightArt; i++) {
                    art.add(br.readLine());
                }
                charMap.put(c, art);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Set<Character> set = charMap.keySet();
        System.out.println(set);
    }

    public void screenArt(String text) {
        for (int i = 0; i < heightArt; i++) {
            for (int j = 0; j < text.length(); j++) {
                if (charMap.containsKey(text.charAt(j))) {
                    System.out.print(charMap.get(text.charAt(j)).get(i) + " ");
                }
            }
            System.out.println();
        }
    }
}