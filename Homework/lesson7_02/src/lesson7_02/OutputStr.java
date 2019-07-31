package lesson7_02;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class OutputStr implements Runnable {

	private Path path;
	private byte[] bytes;
	private String workFile;

	public OutputStr(byte[] bytes, Path path, String copyDirectory) {
		super();
		this.path = path;
		this.bytes = bytes;
		workFile = copyDirectory + "\\" + this.path.getFileName();
	}

	public static void bufferCopyToFile(byte[] bytes, String workFile) throws IOException {

		File out = new File(workFile);
		try (FileOutputStream out1 = new FileOutputStream(out);
				BufferedOutputStream bos = new BufferedOutputStream(out1, 1024)) {
			System.out.print("##");
			bos.write(bytes, 0, bytes.length);

			bos.close();
			System.out.println(" ] end");
		} catch (IOException e) {
			throw e;
		}
	}

	@Override
	public synchronized void run() {
	//	System.out.println(" out " + Thread.currentThread().getName());
		try {
			bufferCopyToFile(bytes, workFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
