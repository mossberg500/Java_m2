package lesson5_02;

import java.io.*;

public class FIleCompare{
	
	
	public static void fileCompare (File firstFile, File secondFile, File resultFile){
		
		try(BufferedReader br1 = new BufferedReader(new FileReader(firstFile)); 
				BufferedReader br2 = new BufferedReader(new FileReader(secondFile));
				PrintWriter pwresFile = new PrintWriter(resultFile)){
			
			StringBuilder stringBuilder1 = new StringBuilder();
			StringBuilder stringBuilder2 = new StringBuilder();
			
			filetoString(br1, stringBuilder1);
			filetoString(br2, stringBuilder2);
			
			String[] string1 = stringBuilder1.substring(0).split(" ");
			String[] string2 = stringBuilder2.substring(0).split(" ");
								
			pwresFile.println(toStringRes(string1, string2));
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
		public static void filetoString(BufferedReader br, StringBuilder stringBuilder) throws IOException {
			String str = "";
			try {
			while ((str=br.readLine()) != null){
				String lowcase = str.toLowerCase();
				stringBuilder.append(lowcase).append(" ");
			}
			}
			catch (IOException e) {
				throw e;
			}
			
			
			
			
		}
		public static String toStringRes(String[] string1, String[] string2) {
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
			return resStr;
		}

	
	

}
