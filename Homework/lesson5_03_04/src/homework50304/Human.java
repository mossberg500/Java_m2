package homework50304;

public class Human  {
    private String name;
    private String surname;
    private int age;
    private double weight;
    private double growth;
    private boolean sex;
    private int idHuman;
    private static int id =-1 ;

    public Human(String name, String surname, int age, double weight, double growth, boolean sex) {
        super();
        idHuman = ++id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.weight = weight;
        this.growth = growth;
        this.sex = sex;

    }

    public Human() {
        super();
        idHuman = ++id;
        this.surname = "";
    }

    public int getIdHuman() {
        return idHuman;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getGrowth() {
        return growth;
    }

    public void setGrowth(double growth) {
        this.growth = growth;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Human{" +
                "idHuman='" + idHuman + '\'' +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", growth=" + growth +
                ", sex=" + sex +
                '}';
    }


}
