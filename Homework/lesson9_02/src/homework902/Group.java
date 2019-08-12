package homework902;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import javax.swing.JOptionPane;

public class Group implements Conscription, Serializable {
    private static final long serialVersionUID = 1L;
    private final static int MAX_GROUP_SIZE = 10;
    private List<Student> students = new ArrayList<Student>();
    private String nameGroup;

    public Group(List<Student> students, String nameGroup) {
        super();
        this.students = students;
        this.nameGroup = nameGroup;
    }
    public Group(String nameGroup) {
        super();

        this.nameGroup = nameGroup;
    }
    public Group() {
        super();
    }
    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    public String getNameGroup() {
        return nameGroup;
    }
    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }
    // Add student in Group
    public void addStud(Student stud) throws MyException {
        if (stud == null) {
            throw new IllegalArgumentException("Null student");
        }
        if (this.students.size() < MAX_GROUP_SIZE) {
            stud.setGroup(nameGroup);
			students.add(stud);
			System.out.println("Added" + " student [ " + stud.toString() + " ] to current Group ");
            return;
        } else {
            throw new MyException();
        }
    }
    public void addStudents() {
        while (true) {
            String input = null;
            input = JOptionPane
                    .showInputDialog("Add student in format: name surname age weight growth sex faculty group" + " \n"
                            + " name surname age weight growth sex faculty group");
            if (input == null) {
                break;
            }
            String[] fields = input.split(" ");
            try {
                String name = fields[0];
                String surname = fields[1];
                int age = Integer.valueOf(fields[2]);
                double weight = Double.valueOf(fields[3]);
                double growth = Double.valueOf(fields[4]);
                boolean sex = Boolean.valueOf(fields[5]);
                String faculty = fields[6];
                String group = fields[7];

                Student student = new Student(name, surname, age, weight, growth, sex, group);
                addStud(student);
                System.out.println(student);
                System.out.println("===========================");
            } catch (IndexOutOfBoundsException e1) {
                JOptionPane.showMessageDialog(null, "Input data are incomplete");
                continue;
            } catch (NumberFormatException e3) {
                JOptionPane.showMessageDialog(null, e3.getMessage());
                continue;
            } catch (MyException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                break;
            }
        }
    }
    // Delete student from Group (null)
    public void delStud(int id) throws studentNotFoundException {
        for (int index = 0; index < students.size(); index++) {
            if (students.get(index) != null && students.get(index).getIdHuman() == id) {
                Student st = students.get(index);
                students.remove(index);
                System.out.println("" + "Student [ " + st.toString() + " ] was successfully deleted " + '\n');
                return;
            }
        }
    }
    // Find student in Group by surname
    public Student findBySurname(String surname) throws studentNotFoundException {
        String res = "";
        for (Student a : students) {
            if (a != null && a.getSurname().equals(surname)) {
                res += "Seach result :  " + surname + " found: " + "[" + a + "]" + '\n';
                System.out.println(res);
                return a;
            }
        }
        throw new studentNotFoundException();
    }

	public void sortGroup() {
		students.sort(Comparator.comparing(Student::getSurname));
	}
    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i) == null) {
                str += " name null " + " surname null " + "age 0 " + " weight 0 " + " growth 0 " + " sex false "
                        + " group null" + '\n';
                continue;
            }
            str += students.get(i).toString() + '\n';
        }
        return str;
    }
    @Override
    public Student[] getConscripts() {
        Student[] conscripts = new Student[students.size()];
        int i = 0;
        for (Student student : students) {
            if ((student != null) && (student.getAge() >= MILITARY_AGE) && (student.isSex() == true)) {
                conscripts[i] = student;
                i++;
            }
        }
        Arrays.sort(conscripts,
                (a, b) -> CheckedNull.checkNull(a, b) != CheckedNull.NOT_NULL ? CheckedNull.checkNull(a, b)
                        : a.getSurname().compareTo(b.getSurname()));
        return conscripts;
    }
}
