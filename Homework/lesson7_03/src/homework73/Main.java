package homework73;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		
		String find = "21700999.zip"; //""ntuser.pol";
        File path = new File("C:\\Users");
        SearchFile searchfile = new SearchFile(find, path);
	}

}