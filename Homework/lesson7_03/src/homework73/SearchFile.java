package homework73;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SearchFile implements Runnable {

	private String seek;
	private File path;
	private ArrayList<File> found;
	private ArrayList<Thread> threads;
	private File[] files;
	private ExecutorService service;

	public SearchFile(String search, File path) {
		super();
		this.seek = search;
		this.path = path;
		files = path.listFiles();
		found = new ArrayList<File>();
		threads = new ArrayList<Thread>();
		service = Executors.newScheduledThreadPool(4);
		service.submit(this);
	}

	public void searching(File[] files) {
		if (files == null)
			return;
		for (File i : files) {

			if (i.isDirectory()) {
				service.submit(new Seeker(i.listFiles(), this));
				threads.add(Thread.currentThread());

			}

			if (i.isFile() && i.getName().equalsIgnoreCase(seek)) {
				System.out.format("%s has found %s\n", Thread.currentThread().getName(), i.getName());
				found.add(i);
				for (File ii : found) {
					System.out.println(ii.getAbsoluteFile());
				}

			}

		}

	}

	@Override
	public void run() {
		searching(files);
		try {
			service.awaitTermination(15, TimeUnit.SECONDS);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (found.size() == 0) {
			System.out.println(Thread.currentThread() + "Nothing was found!");
		}
		service.shutdown();
	}
}