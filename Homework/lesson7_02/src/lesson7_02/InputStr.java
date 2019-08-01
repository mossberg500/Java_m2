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

	
	
	public Path getPath() {
		return path;
	}



	public void setPath(Path path) {
		this.path = path;
	}



	public String getFilein() {
		return filein;
	}



	public void setFilein(String filein) {
		this.filein = filein;
	}



	public  int progress(int i) throws IOException {
		path = Paths.get(filein);
		int n = Files.readAllBytes(path).length;
		return (int) (Math.ceil(i / n * 100));
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
				System.out.print(" ## " + progress(i) + "%");
			}
			System.out.println(" array " + i + " of " + bytes.length + "  bytes");
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
