package homework3;

import java.util.Arrays;

public class Group {
    private Student[] stud = new Student[10];

    public Group(Student[] stud) {
        super();
        this.stud = stud;
    }

    public Group() {
        super();
    }
    public Student[] getStud1() {
        return stud;
    }

    public void setStud1(Student[] stud) {
        this.stud = stud;
    }

    public Student getStud(int index) throws ArrayIndexOutOfBoundsException {
        if(index<0 && index>this.stud.length-1)
            throw new ArrayIndexOutOfBoundsException();
            return stud[index];
    }

    public void setStud(Student stud, int index) throws ArrayIndexOutOfBoundsException {
        if(index<0 && index>this.stud.length-1)
            throw new ArrayIndexOutOfBoundsException();
        this.stud[index] = stud;
    }

    //Group output for verification
    public void PrintGroup(Student[] stud) {
        for (Student x : stud)
            System.out.println(x);
    }


}
