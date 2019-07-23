package lesson6_01;

import java.math.BigInteger;



public class FactorialThread {
	
	private Thread[] threads = new Thread[100];

	 public FactorialThread() {

	    }

	public Thread[] getThreads() {
	        return threads;
	    }
	    
	    
	public void iniThreads() {
        for (int i = 0; i < threads.length; i += 1) {
            int num = i;
            Runnable runnable = () ->{
            	System.out.println(threads[num].getName() + " " + num + "!= " + calculateFactorial(num));
            };
        threads[i] = new Thread(runnable, "Thread_" + num);
        System.out.println("thread " + threads[num].getName() + " created");
        }
    }   
	    
	    
	 public void threadStart() {
	        iniThreads();
	        for (int i = 0; i < threads.length; i += 1) {
	            threads[i].start();
	            System.out.println(threads[i].getName() + " started");
	        }
	    }

	
private BigInteger calculateFactorial(int number) {
	BigInteger fact = new BigInteger("1");
	for (int i = 2; i <= number; i++) {
		fact = fact.multiply(new BigInteger("" + i));
		
	}
	return fact;
}


}
