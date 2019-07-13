package lesson501;

import java.io.*;

import org.omg.CORBA.PUBLIC_MEMBER;

public class FileCopyService {
	
	public static void fileCopy(File in, File out) throws IOException {
		byte[] buffer = new byte[1024*1024];
		int readByte = 0;
		
		try(FileInputStream fis = new FileInputStream(in);
				FileOutputStream fos = new FileOutputStream(out)){
			for (; (readByte = fis.read(buffer))>0;) {
				fos.write(buffer, 0, readByte);
			}
			
		}catch (IOException e) {
			throw e;
		}
	}

	public static void copyFilesFilter(File inputpath, File outpath, String... filefilter) throws IOException {
		String fileN;
		MyFileFilter mFF = new MyFileFilter(filefilter);
	
		String inPathstr = inputpath.getAbsolutePath();
		if(inPathstr.charAt(inPathstr.length()-1) != '\\')
			inPathstr = inPathstr + '\\';
		
		File[] filelist = inputpath.listFiles(mFF);
	
		String outPathstr = outpath.getAbsolutePath();
		if(outPathstr.charAt(outPathstr.length()-1) != '\\')
			outPathstr = outPathstr + '\\';
		
		for (File file : filelist) {
			fileN = file.getName();
			File outfile = new File(outPathstr + fileN);
			fileCopy(file, outfile);
		}
	}
		
		public static void listF(File file) {
		if (!file.isFile()) {
			File [] fileArray = file.listFiles();
		for(File fileOne : fileArray) {
			long fileSize = calculateFolderSize(fileOne);
			String type = (fileOne.isFile())?"File": "Folder";
			System.out.println(fileOne.getName()+"\t"+type+"\t"+fileSize);
		}
		}
	}
		
		public static long calculateFolderSize(File file) {
			if(file.isFile()) {
				return file.length();
			} else {
				long size = 0;
				File[] fileArray = file.listFiles();
				for (File fileOne : fileArray) {
					size += calculateFolderSize(fileOne);
				}
				return size;
			}
			
			
		}
		
}
