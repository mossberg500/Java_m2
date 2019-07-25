package lesson7_01;

import java.util.concurrent.Semaphore;

public class Semaphor {
	private int box;
	
	Semaphore semDok = new Semaphore(0);
	Semaphore sem = new Semaphore(1, true);
	
	void getBox() {
		
		try {
			semDok.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (box = 20; box >= 1; box--) {
			
			try {
				Thread.currentThread().sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		System.out.println(Thread.currentThread().getName() + "  Осталось  получить " + box + '\t');
		}
		sem.release();
	}

	void putBox(int n) {
		
		try {
			sem.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.box = n;
		for (box = 1; box <= 20; box++) {
			try {
				Thread.currentThread().sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "  Отпрвлено  " + box+'\t');
		}
		semDok.release();
	}
}
