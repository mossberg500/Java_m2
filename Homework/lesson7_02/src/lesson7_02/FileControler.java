package lesson7_02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class FileControler {

	private ExecutorService service;
	private String filein;
	private Path path;
	private String copyDirectory;

	public FileControler(String filein, String copyDirectory) {
		super();
		this.copyDirectory = copyDirectory;
		this.filein = filein;
		path = Paths.get(filein);
		service = Executors.newScheduledThreadPool(2);
	}

	public void Copy() {
		try {
			byte[] bytenew = null;
			if (Files.exists(Paths.get(copyDirectory + "\\" + path.getFileName()))) {
				Files.delete(Paths.get(copyDirectory + "\\" + path.getFileName()));
			}

			InputStr inputStr = new InputStr(path, filein);
			Future<byte[]> future = service.submit(inputStr);
			byte[] bytes;
			try {
				bytes = future.get();
				if (bytes != null) {
					bytenew = new byte[bytes.length];
					System.arraycopy(bytes, 0, bytenew, 0, bytes.length);
				}
				System.out.println("Buffer ready");
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} catch (ExecutionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				service.awaitTermination(1, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (future.isDone())
				service.submit(new OutputStr(bytenew, path, copyDirectory));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			service.shutdown();

		}
	}

}