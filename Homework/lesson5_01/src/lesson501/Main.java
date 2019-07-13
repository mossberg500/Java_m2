package lesson501;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		
		File file = new File(".");
	
		File folderFrom = new File("A");
		folderFrom.mkdirs();
		
		File folderIn = new File("B");
		folderIn.mkdirs();
		
		FileCopyService.listF(file);
		
		File fileThree = new File(folderFrom, "c.txt");
		try {
			fileThree.createNewFile();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("-------A--------");
		FileCopyService.listF(folderFrom);
		System.out.println("-------B--------");
		FileCopyService.listF(folderIn);
		
		try {
			FileCopyService.copyFilesFilter(folderFrom, folderIn, "docx", "pdf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("----Folder---B--After copy------");
		FileCopyService.listF(folderIn);
		
		
	}
}
