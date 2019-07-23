package lesson6_04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopier implements Runnable {
	
        private int start;
        private int end;
        private int index;
        private String readFrom;
        private File writeTo;
        private Thread thr;

        public FileCopier() {
        	super();
        }

        public FileCopier(String readFrom, File writeTo, int start, int end, int index) {
        	super();
            this.readFrom = readFrom;
            this.writeTo = writeTo;
            this.start = start;
            this.end = end;
            this.index = index;
            thr = new Thread(this);
            thr.start();
            
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getIndex() {
            return index;
        }
        
        
        

        public Thread getThr() {
			return thr;
		}

        
        public static  File[] getFiles(String path) {
            File[] files = new File[1];
            File direct = new File(path);
            if (direct.isDirectory()) {
                files = direct.listFiles();
                return files;
            }
            files[0] = direct;
            return files;
        }  
        
        
		public void copyFiles(String copyFrom, File copyTo, int start, int end) {
            int copy = 1;
            File [] files = getFiles(copyFrom);            
            try { 
                if (copyTo.isDirectory()) {
                    for (int i = start; i < end; i += 1) {
                        File write = new File(copyTo, "newFile_" +  files[i].getName());
                        copyStream(files[i], write);
                        copy++;
                        System.out.println("copy  " + files[i].getName());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();

            }

        }

        public void copyStream(File readFrom, File writeTo) throws FileNotFoundException, IOException {
            byte[] buffer = new byte[1024 * 1024];
            int byteRead = 0;
            try (FileInputStream reader = new FileInputStream(readFrom); FileOutputStream writer = new FileOutputStream(writeTo)) {
                for (; (byteRead = reader.read(buffer)) > 0;) {
                    writer.write(buffer, 0, byteRead);
                }
            } catch (IOException e) {
            	e.printStackTrace();
            }
        }

        

        @Override
        public void run() {
        	System.out.println("Thread started   " +  thr.currentThread().getName());
            copyFiles(this.readFrom, this.writeTo, this.start, this.end);
            

        }

}

