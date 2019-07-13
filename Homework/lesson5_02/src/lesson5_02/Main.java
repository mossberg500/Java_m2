package lesson5_02;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		
		File fileOne = new File("1.txt");
		File fileTwo = new File("2.txt");
		File resultFile = new File("resultFile.txt");
		
		try {
			resultFile.createNewFile();
		}catch (IOException e) {
			e.printStackTrace();
		}
				
		String text1 = "this strings against given regular expression and returns a char array";
		String text2 = " limit for the number of strings in array";
		
		
		try (PrintWriter pw1 = new PrintWriter(fileOne)) {
			pw1.println(text1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("ERROR FILE WRITE");
		}
		
		try (PrintWriter pw2 = new PrintWriter(fileTwo)) {
			pw2.println(text2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("ERROR FILE WRITE");
		}
		
		FIleCompare.fileCompare(fileOne, fileTwo, resultFile);
	
	}

}
