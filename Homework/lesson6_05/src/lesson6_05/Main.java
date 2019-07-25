package lesson6_05;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        File folder = new File(".");
        
        FileWatcher tablo = new FileWatcher(folder);
        
        Waiter waiter = new Waiter(tablo);
        new Thread(waiter,"waiter").start();
         
         
        Notifier notifier = new Notifier(tablo);
        new Thread(notifier, "notifier").start();
        System.out.println("Стартовали все потоки");
        
        
    }
}
