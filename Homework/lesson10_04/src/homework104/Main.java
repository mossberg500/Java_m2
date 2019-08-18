package homework104;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String file = "Letters.txt";
        StringArt sArt = new StringArt(file);
        try {
            sArt.inicArt();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);
        String str = "";
        while (!str.equals("exit")) {
            System.out.println("¬ведите текст:");
            str = sc.nextLine();
            sArt.screenArt(str);
        }
    }
}