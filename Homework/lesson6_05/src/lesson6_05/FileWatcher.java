package lesson6_05;


import java.io.File;
import java.text.SimpleDateFormat;

public class FileWatcher {
    private File mainFolder;
    private File[] currentFileArray;
    private File[] previousFileArray;
    
    public static boolean flag = true;

    public FileWatcher(File mainFolder) {
        this.mainFolder = mainFolder;
        previousFileArray = mainFolder.listFiles();
    }

    public File getMainFolder() {
        return mainFolder;
    }

    private String getFolderInfo() {
        if (mainFolder == null) {
            return "None";
        }

        currentFileArray = mainFolder.listFiles();

        StringBuilder sb = new StringBuilder();
        for (File file : currentFileArray) {
            sb.append(file.getName() + "\t" + file.length()).append(System.lineSeparator());
        }
        sb.append(fileCompare());
        previousFileArray = mainFolder.listFiles();

        if(flag) {
        return sb.toString();
        }
        return "wait chahges";
    }

    private String fileCompare(){
        StringBuilder sb = new StringBuilder();
        if (currentFileArray.length > previousFileArray.length){
            for (int i = 0; i < currentFileArray.length; i++){
                int j;
                for (j = 0; j < previousFileArray.length; j++){
                    if (currentFileArray[i] == previousFileArray[j]){
                        break;
                    }
                }
                if (i == previousFileArray.length){
                	flag = true;
                    sb.append("new file \"" + currentFileArray[i].getName() +"\" has been added to the folder");
                }
            }

        }
        if (currentFileArray.length < previousFileArray.length){
            for (int i = 0; i < previousFileArray.length; i++){
                int j;
                for (j = 0; j < currentFileArray.length; j++){
                    if (previousFileArray[i] == currentFileArray[j]){
                        break;
                    }
                }
                if (i == currentFileArray.length){
                	flag = true;
                    sb.append("file \"" + previousFileArray[i].getName() +"\" has been removed from the folder");
                }
            }
        }

        return sb.toString();
    }
    
    public boolean tabloFlag() {
    	System.out.println(getFolderInfo());
        System.out.println(fileCompare());
    	return flag;
    }
      public void Tablo() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy   hh:mm:ss");
            System.out.println(sdf.format(System.currentTimeMillis()));
            System.out.println(getFolderInfo());
            System.out.println(fileCompare());
            System.out.println();

            }
    
}






