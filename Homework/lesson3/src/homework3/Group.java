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
    //Add student in Group
    public void setStud(Student stud, int index) throws ArrayIndexOutOfBoundsException {
        if(index<0 && index>this.stud.length-1)
            throw new ArrayIndexOutOfBoundsException();
        this.stud[index] = stud;
    }
    //Delete student from Group (null)
    public void delStud(int index)throws ArrayIndexOutOfBoundsException{
        if(index<0 && index>this.stud.length-1)
            throw new ArrayIndexOutOfBoundsException();
        this.stud[index] = null;
    }
    //Find student in Group by surname
    public Student findBySurname(String surname){
        for (Student a : this.stud){
            if (a.getSurname().compareToIgnoreCase(surname) == 0 )
                return a;
        }
        return null;

    }



    //Group output for verification
    public void PrintGroup(Student[] stud) {
        for (Student x : stud)
            System.out.println(x);
    }


}
