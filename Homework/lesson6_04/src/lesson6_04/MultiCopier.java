package lesson6_04;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class MultiCopier {
	 
	
	 public static void multithreadCopier(String readFrom, String writeTo, int threadCount) {
	        File writeToDir = new File(copyDirectory(readFrom, writeTo));
	        List<FileCopier> workers = getWorkersList(readFrom, threadCount, writeToDir);
	       
	        for (FileCopier w : workers) {
	            try {
	                w.getThr().join();
	            } catch (InterruptedException e) {
	            }
	        }

	    }

	    public static List<FileCopier> getWorkersList(String readFrom, int count, File writeTo) {
	        int startOfArray = 0;
	        int endEnfOfArray = 0;
	        count = realThreadQuantity(count);
	        File[] array = FileCopier.getFiles(readFrom);
	        int size = (int) (array.length / count);
	        List<FileCopier> arrays = new ArrayList<>();
	        if (array.length == 0) {
	            return arrays;
	        }
	            for (int i = 0; i < count; i++) {
	                if (endEnfOfArray == array.length) {
	                    return arrays;
	                }
	                startOfArray = size * i;
	                endEnfOfArray = (int) ((i + 1) * size);
	                if ((array.length - endEnfOfArray) < size) {
	                    endEnfOfArray = array.length;
	                }
	                arrays.add(new FileCopier(readFrom, writeTo, startOfArray, endEnfOfArray, i));
	                
	            }
	        
	        return arrays;
	    }

	    public static int realThreadQuantity(int count) {
	        int availableProcessors = Runtime.getRuntime().availableProcessors();
	        if (count > availableProcessors) {
	            count = availableProcessors;
	        }
	        return count;
	    }
	
	 public static String copyDirectory(String directory, String copyTo) {
         boolean result = false;
         String path = "";
         File toCopy = new File(directory);
         File copyOfDir = new File(copyTo, toCopy.getName() + "_newcopy");
         if (!copyOfDir.exists()) {
             result = copyOfDir.mkdir();
             if (result) {
                 System.out.println("Directory is created");
             } else {
                 System.out.println("Directory is not created");
             }  
         }
         return path = copyOfDir.getAbsolutePath();
     }

}
