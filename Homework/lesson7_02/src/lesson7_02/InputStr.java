package lesson7_02;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

public class InputStr implements Callable<byte[]> {

	private Path path;
	private String filein;

	public InputStr(Path path, String filein) {
		super();
		this.path = path;
		this.filein = filein;
	}

	public byte[] fileCopyToBuffer(String filein) throws IOException {
		System.out.println(" Start coping [ ");
		File in = new File(filein);
		path = Paths.get(filein);
		int lengthFile = Files.readAllBytes(path).length;
		byte[] bytes = new byte[lengthFile];
		int readByte = 0;
		int i = 0;
		try (FileInputStream fis = new FileInputStream(in);
				BufferedInputStream bis = new BufferedInputStream(fis, 1024)) {
			for (; (readByte = bis.read()) != -1;) {
				bytes[i] = (byte) readByte;
				i += 1;
				System.out.print("##");
			}
			System.out.println(" array of " + bytes.length + "  bytes");
			return bytes;
		} catch (IOException e) {
			throw e;
		}
	}

	@Override
	public byte[] call() throws Exception {
//		System.out.println(" read " + Thread.currentThread().getName());
		return fileCopyToBuffer(filein);
	}

}
