package lesson6_04;



public class Main {

	  public static void main(String[] args) {
	        String readFromDir = "folder\\";
	        String writeToDir = "C:\\Users\\oleg\\Videos\\";

	        MultiCopier.multithreadCopier(readFromDir, writeToDir, 5);
	    }

}
