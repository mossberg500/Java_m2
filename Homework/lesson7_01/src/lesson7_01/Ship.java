package lesson7_01;


import java.util.concurrent.Semaphore;

public class Ship implements Runnable {
	
	  private Semaphor semaphor;   
	  private String nameship;
	  private Thread th;
	  private int box;
	
	
	  public Ship() {
			super();
			// TODO Auto-generated constructor stub
		}
	  
	  public Ship( Semaphor semaphor, String nameship, int box) {
			super();
			this.box = box;
			this.semaphor = semaphor;
			this.nameship = nameship;
			th = new Thread(this, nameship);
		}


	public Thread getTh() {
		return th;
	}

	public String getNameship() {
		return nameship;
	}

	public void setNameship(String nameship) {
		this.nameship = nameship;
	}

	@Override
	public void run() {
			 
			 semaphor.putBox(box);
			
		}
		
}
