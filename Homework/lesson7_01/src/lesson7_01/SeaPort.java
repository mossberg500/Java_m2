package lesson7_01;


import java.util.concurrent.Semaphore;

public class SeaPort implements Runnable {
	private String doker;
	private Semaphor semaphor;   
	 private Thread th;
	
	public SeaPort(Semaphor semaphor, String doker) {
		super();
		this.doker = doker;
		this.semaphor = semaphor;
		th = new Thread(this, doker);
	}

	public Thread getTh() {
		return th;
	}

	public SeaPort() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDoker() {
		return doker;
	}

	public void setDoker(String doker) {
		this.doker = doker;
	}
	@Override
	public void run() {
			semaphor.getBox();
			
	}
	
}		
	