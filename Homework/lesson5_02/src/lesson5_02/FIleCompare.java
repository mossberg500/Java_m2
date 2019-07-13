package lesson5_02;

import java.io.*;

public class FIleCompare{
	
	
	public static void fileCompare (File firstFile, File secondFile, File resultFile){
		
		try(BufferedReader br1 = new BufferedReader(new FileReader(firstFile)); 
				BufferedReader br2 = new BufferedReader(new FileReader(secondFile));
				PrintWriter pwresFile = new PrintWriter(resultFile)){
			String str1 = "";
			String str2 = "";
			StringBuilder stringBuilder1 = new StringBuilder();
			StringBuilder stringBuilder2 = new StringBuilder();
			
			while ((str1=br1.readLine()) != null){
				String lowcase1 = str1.toLowerCase();
				stringBuilder1.append(lowcase1).append(" ");
			}
			
			while ((str2=br2.readLine()) != null){
				String lowcase2 = str2.toLowerCase();
				stringBuilder2.append(lowcase2).append(" ");
			}
			
			String[] string1 = stringBuilder1.substring(0).split(" ");
		
			String[] string2 = stringBuilder2.substring(0).split(" ");
								
			String resStr = "";
			for (int j = 0; j < string1.length; j++) {
				for (int i = 0; i < string2.length; i++) {
					if (string1[j].equals(string2[i])) {
						if (resStr != "")
							resStr = resStr + " " + string1[j];
						else 
							resStr = resStr + string1[j];
						System.out.println(resStr);
					}
					
				}
				
			}
			
			pwresFile.println(resStr);
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
}
	

}
