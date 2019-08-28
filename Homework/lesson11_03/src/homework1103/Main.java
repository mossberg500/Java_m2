package homework1103;

public class Main {
    public static void main(String[] args) {
        String forTestOne = "https://rozetka.com.ua/";
        String forTestTwo = "https://comfy.ua/";
        String forTestThree = "https://www.i.ua/";
        String forTestFour = "https://korrespondent.net/";

        Searcher s = new Searcher(forTestFour);
        s.writeLiksToFile();
        System.out.println(" File folderOne\\Links.txt is ready ");
    }
}
