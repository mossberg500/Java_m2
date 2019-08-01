package homework73;

import java.io.File;

public class Seeker implements Runnable {

	private SearchFile search;
	private File[] files;

	public Seeker(File[] files, SearchFile search) {
		this.search = search;
		this.files = files;
	}

	@Override
	public void run() {
		search.searching(files);

	}
}