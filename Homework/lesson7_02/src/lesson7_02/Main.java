package lesson7_02;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
    	
		String in = "C:\\111\\PUNK.txt";
		String out = "C:\\222";
		FileControler filecontroler = new FileControler(in, out);
		filecontroler.Copy();
		
    }
}