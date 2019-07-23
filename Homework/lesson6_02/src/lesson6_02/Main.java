package lesson6_02;

import java.util.Random;

public class Main {

	public static void main(String[] args) {

		int count = 10;
		
		int[] array1 = new int[10000000];
		
		Random rn = new Random();
		for (int i = 0; i < array1.length; i++) {
//			array1[i] = 5;	
			array1[i] = rn.nextInt(10);
		}
		int[] array2 = array1.clone();
		int[] array3 = array1.clone();

		long timestart1 = System.currentTimeMillis();
		System.out.print("sum = " + MultiThread.sumArrays(MultiThread.Arraysformation(array1, count)) +'\t');
		long timeend1 = System.currentTimeMillis();
		System.out.println((timeend1 - timestart1) + " ms" + " - MultiThread with  " + count + "  threads");

		long timestart2 = System.currentTimeMillis();
		System.out.print("sum = " + MultiThread.SumSingleThread(array2, 0 , array2.length)+'\t');
		long timeend2 = System.currentTimeMillis();
		System.out.println((timeend2 - timestart2) + " ms" + " - SingleThread");

		
		long timestart3 = System.currentTimeMillis();
		System.out.print("sum = " + MultiThread.sumArrays(MultiThread.Arraysformation(array3, Runtime.getRuntime().availableProcessors()))+ '\t');
		long timeend3 = System.currentTimeMillis();
		System.out.println((timeend3 - timestart3) + " ms" + " - MultiThread with  " + Runtime.getRuntime().availableProcessors() + "  core autodetected");
	}
	
}
