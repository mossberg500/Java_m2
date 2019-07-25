package lesson7_01;

public class Main {

	public static void main(String[] args) {
			Semaphor sem = new Semaphor();
			Semaphor sem1 = new Semaphor();
			Thread th1 = new Ship(sem, "ship A", 20).getTh();
			Thread th2 = new Ship(sem1, "ship B", 20).getTh();
			Thread th3 = new Ship(sem, "ship C", 20).getTh();
			
			th1.start();
			th2.start();
			th3.start();
			
			new SeaPort(sem, "1 doker").getTh().start();
			new SeaPort(sem, "1 doker").getTh().start();
			new SeaPort(sem1, "2 doker").getTh().start();
	}
}
