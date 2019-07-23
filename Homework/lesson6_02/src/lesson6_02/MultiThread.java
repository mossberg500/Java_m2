package lesson6_02;

import java.util.List;





public class MultiThread {
	public static InnerThead[] Arraysformation(int[] array, int count) {

		InnerThead[] threadarray = new InnerThead[count];
		Thread[] th = new Thread[count]; 

		for (int i = 0; i < th.length; i++) {
			int size = (int)(array.length / count);
			int begin = size * i;
			int end = (i + 1) * size;
			if ((array.length - end) < size) {
				end = array.length;
			}

			threadarray[i] =new InnerThead(array, begin, end);
			th[i] = new Thread(threadarray[i]);
		}

		multyThreadsStart(th);
		return threadarray;
	}
	
	public static void multyThreadsStart(Thread[] thr)  {
        for(int i = 0; i < thr.length; i+=1)
        	thr[i].start();
        for(int i = 0; i < thr.length; i+=1)
        	try {
        		thr[i].join();
        	}
        catch (InterruptedException e) {
        	e.printStackTrace();
        }
        
  }
        
	public static int sumArrays(InnerThead[] threadarray) {
		int arrSum = 0;
		for (int i = 0; i < threadarray.length; i++) {
			arrSum += threadarray[i].getSum();
		}
		return arrSum;
	}
	
	
	public static int SumSingleThread(int[] array, int begin, int end) {
		SingleThread single = new SingleThread(array, begin, end);
		try {
			single.getThr().join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int arrSum = single.getSum();
		return arrSum;
	}
	
	private static class InnerThead implements Runnable{
		private int[] array;
		private int begin;
		private int end;
		private int sum;
		public InnerThead(int[] array, int begin, int end) {
			super();
			this.array = array;
			this.begin = begin;
			this.end = end;
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
		public int getSum() {
			int sum = 0;
			for (int i = begin; i < end; i++) {
				sum = sum + array[i];
			}
			return sum;	
		}
		@Override
		public void run() {
			Thread  tr = Thread.currentThread();
			getSum();
			System.out.println(tr.getName() + "  MultiThreader");
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
}
