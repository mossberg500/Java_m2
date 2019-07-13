package homework50304;

import java.io.*;

public class SaveAndLoadToFile {
	public static void saveGroup(Group group){
        File f = new File("Group.csv");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))){
            for (Student i:group.getStudents()) {
                if (i != null){
                    bw.write(i.getName() + "," + i.getSurname() + "," + i.getAge() + "," + i.getWeight() + "," + i.getGrowth() + "," + i.isSex() + "," + i.getFaculty() + "," + i.getGroup());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("\n" + "Group is saved to File Group.csv" + "\n");
    }

    public static Group loadGroup(String file){
        File f = new File(file);
        Group group = new Group();
        try (BufferedReader br = new BufferedReader(new FileReader(f))){
            String str = "";
            for (; (str = br.readLine()) != null;) {
                String[] str1 = str.split(",");
                group.addStud(new Student(str1[0], str1[1], Integer.valueOf(str1[2]), Double.valueOf(str1[3]), Double.valueOf(str1[4]), Boolean.valueOf(str1[5]), str1[6], str1[7]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        System.out.println("\n" + "Group is loaded from File "+ file + "\n");
        return group;
    }

}
