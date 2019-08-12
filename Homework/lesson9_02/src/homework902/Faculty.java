package homework902;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Faculty implements Serializable {
    private List<Group> groups = new ArrayList<>();
    private String nameFaculty;

    public Faculty(String nameFaculty) {
        this.nameFaculty = nameFaculty;

    }

    public Faculty() {
        super();
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public String getNameFaculty() {
        return nameFaculty;
    }

    public void setNameFaculty(String nameFaculty) {
        this.nameFaculty = nameFaculty;
    }

    public void addInFaculty(Group group) {
        groups.add(group);
    }

    public void removeFromFaculty(String group) {
        for (Group gr : groups) {
            if (gr.getNameGroup().equals(group)) {
                groups.remove(gr);
            }
        }
    }

    public void clearFaculty() {
        groups.clear();
        System.out.println(" Faculty   clear  ");
    }

    public void saveGroupToDB() {
        for (Group gr : groups) {
            File facultyFile = new File(gr.getNameGroup() + ".txt");
            try {
                facultyFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();

            }
            try (ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream(facultyFile))) {
                OOS.writeObject(gr);
                OOS.flush();
                OOS.close();
                System.out.println("DB has been saved in file " + gr.getNameGroup() + ".txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void loadDB(String loadfile) {
        File file = new File(loadfile);
        int pos = loadfile.lastIndexOf(".");
        removeFromFaculty(loadfile.substring(0, pos));
        Group grLoad = new Group();
        try (ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(file))) {

            grLoad = (Group) OIS.readObject();
            groups.add(grLoad);
            System.out.println("DB has been loaded from " + loadfile);

        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            System.out.println("ERROR load group !!!");
            e.printStackTrace();

        }

    }

    @Override
    public String toString() {
        return "Faculty{" + "groups=" + groups + ", nameFaculty='" + nameFaculty + '\'' + '}';
    }
}
