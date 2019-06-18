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


    public Student getStud(Student[] stud, int index) {
        try {
            return stud[index];
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(" Вы вышли за граници массва");
        }
        return new Student("","",0,0,0,false,"0","0");
    }

    public void setStud(Student stud, int index) {
        try {
            this.stud[index] = stud;
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(" Вы вышли за граници массва");
        }
    }

    //Вывод группы для проверки
    public void PrintGroup(Student[] sdud) {
        for (Student x : sdud)
            System.out.println(x);
    }


}
