package homework4;

import java.util.Arrays;

public class Group {
    private Student[] students = new Student[10];

    public Group(Student[] students) {
        this.students = students;
    }

    public Group() {
        super();
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }


    //Add student in Group
    public void addStud(Student stud) throws MyException {
        for (int index = 0; index < this.students.length; index++) {
            if (this.students[index] == null || (this.students[index].getName().equals("") || this.students[index].getSurname().equals(""))) {
                this.students[index] = stud;
                System.out.println("Added" + " student [ " + stud.toString() + " ] to current Group " + '\n');
                return;
            }
        }
        throw new MyException();
    }

    //Delete student from Group (null)
    public void delStud(int id) throws studentNotFoundException {
        for (int index = 0; index < students.length; index++) {
            if (students[index] != null && students[index].getIdHuman() == id) {
                Student st = students[index];
                students[index] = null;
                System.out.println("" + "Student [ " + st.toString() + " ] was successfully deleted " + '\n');
                return;
            }
        }

    }

    //Find student in Group by surname
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
        Student buf;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < students.length - 1; i++) {
                if (students[i] == null && students[i + 1] != null) {
                    continue;
                } else if (students[i] == null && students[i + 1] == null) {
                    continue;
                } else if (students[i] != null && students[i + 1] == null) {
                    isSorted = false;
                    buf = students[i];
                    students[i] = students[i + 1];
                    students[i + 1] = buf;
                    continue;
                }
                if (students[i].getSurname().compareToIgnoreCase(students[i + 1].getSurname()) > 0) {
                    isSorted = false;
                    buf = students[i];
                    students[i] = students[i + 1];
                    students[i + 1] = buf;
                }
            }

        }
    }


    public void setStudForNottNull(Student stud, int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 && index > this.students.length - 1)
            throw new ArrayIndexOutOfBoundsException();
        this.students[index] = stud;
    }

    public void setNoNull() {
        for (Student x : students) {
            if (x == null) {
                setStudForNottNull((new Student("", "", 0, 0, 0, false, "", "")), Arrays.asList(getStudents()).indexOf(x));
            }
        }
    }
    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                str += " name null " + " surname null " + "age 0 " + " weight 0 " + " growth 0 " + " sex false " + " faculty null " + " group null" + '\n';
                continue;
            }
            str += students[i].toString() + '\n';
        }
        return str;
    }
}
