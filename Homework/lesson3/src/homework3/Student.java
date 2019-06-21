package homework3;

public class Student extends Human  {
    private  String faculty;
    private  String group;


    public Student(String name, String surname, int age, double weight, double growth, boolean sex, String faculty, String group) {
        super(name, surname, age, weight, growth, sex);
        this.faculty = faculty;
        this.group = group;


    }

    public Student() {
        super();

    }


    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }



    @Override
    public String toString() {
        return "Student{" +
                "faculty='" + faculty + '\'' +
                ", group='" + group + '\'' +
                "} " + super.toString();
    }
}
