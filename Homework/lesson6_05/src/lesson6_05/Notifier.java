package lesson6_05;

public class Notifier implements Runnable {
	 
    private FileWatcher tablo;
     
    public Notifier(FileWatcher tablo) {
        this.tablo = tablo;
    }
 
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for(;;) {
        	
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
			
			if(tablo.tabloFlag()) {
			
        	System.out.println(name + " стартовал");
        	try {
        		Thread.sleep(1000);
        		synchronized (tablo) {
        			//  msg.setMsg(name + " поток Notifier отработал");
        			//  msg.notify();
        			tablo.notifyAll();
        			tablo.flag = false;
        			System.out.println(name + " поток Notifier отработал");
        			tablo.wait();
        		}
        	} catch (InterruptedException e) {
        		e.printStackTrace();
         }
        	
        	
			}
			
			
		}	
    }
        
        
}