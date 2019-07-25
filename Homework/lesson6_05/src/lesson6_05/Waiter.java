package lesson6_05;

import java.text.SimpleDateFormat;

public class Waiter implements Runnable{
    
    private FileWatcher tablo;
     
    public Waiter(FileWatcher m){
        this.tablo = m;
    }
 
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy   hh:mm:ss");
        for(;;) {
        synchronized (tablo) {
            try{
                System.out.println(name + " זהול גûחמג לועמהא notify: " + sdf.format(System.currentTimeMillis()));
                tablo.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(name + " בûכ גûחמג לועמהא notify: " + sdf.format(System.currentTimeMillis()));
            tablo.Tablo();
            tablo.flag = false;
            tablo.notifyAll();
        }
        
        }
    }
}