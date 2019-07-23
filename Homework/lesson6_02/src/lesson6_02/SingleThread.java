package lesson6_02;

import java.util.Arrays;

public class SingleThread implements Runnable {
	
	private int[] array;
	private int begin;
	private int end;
	private Thread thr;
	private int sum;

	public SingleThread() {
		super();
	}
	public SingleThread(int[] array, int begin, int end) {
		super();
		this.array = array;
		this.begin = begin;
		this.end = end;
		thr = new Thread(this);
		thr.start();
		
	}
	public int[] getArray() {
		return array;
	}
	public void setArray(int[] array) {
		this.array = array;
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public Thread getThr() {
		return thr;
	}
	public void setThr(Thread thr) {
		this.thr = thr;
	}
	public int getSum() {
		int sum = 0;
		for (int i = begin; i < end; i++) {
			sum = sum + array[i];
		}
		return sum;	
	}
	
	@Override
	public String toString() {
		return "SingleThread [array=" + Arrays.toString(array) + ", begin=" + begin + ", end=" + end + ", thr=" + thr
				+ ", sum=" + sum + "]";
	}
	@Override
	public void run() {
		Thread  tr = Thread.currentThread();
		getSum();
		System.out.println(tr.getName() + "  SingleThreader");
	}
	


}
