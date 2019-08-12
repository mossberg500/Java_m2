package homework903;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class NumOfCharacters {

    private String path;
    private SortedSet<Character> characters;
    private List<Chars> chars;
    private Map<Character, Integer> countMap;

    public NumOfCharacters(String path) {
        this.path = path;
        countMap = new HashMap<>();
    }


    public List<Chars> getChars() {
        return chars;
    }

    private void setAlphabet() {
        for (char cr = 'a'; cr <= 'z'; cr++) { // low letters
            countMap.put(cr, 0);
        }
    }

    public void read() {
        chars = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            int symbol;
            while ((symbol = reader.read()) != -1) {
                if (Character.isAlphabetic(symbol)) {
                    Character ch = (char) symbol;
                    chars.add(new Chars(Character.toLowerCase(ch), 1));
                    System.out.println(Character.toLowerCase(ch));
                }
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public Map<Character, Integer> mapResult (){
        setAlphabet();
        for (Chars item: chars) {
            if (countMap.containsKey(item.getCh()))
                countMap.put(item.getCh(), countMap.get(item.getCh()) + 1);
            else
                countMap.put(item.getCh(), 1);
        }
        return countMap;
    }

    public Map<Character, Integer> countCharacters() {
        read();
        Map<Character, Integer> mapOfresults = mapResult();
        return mapOfresults;
    }


}
