package homework903;

import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String path = "PUNK.txt";

        NumOfCharacters counter = new NumOfCharacters(path);
        Map<Character, Integer> counterResult = counter.countCharacters();
        System.out.println(counterResult);
        Set<Character> keys = counterResult.keySet();
        for (Character k : keys) {
            double percent = counterResult.get(k) * 100.0 / counter.getChars().size();
            if (percent != 0)
            System.out.println(k + " = " + percent + "%");
        }
    }
}
