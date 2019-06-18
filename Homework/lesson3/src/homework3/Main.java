package homework3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student stOne = new Student("Ivan", "Ivanov", 22, 60, 170, true, "Biology", "Three");
        Student stTwo = new Student("Agatha", "MacDonald", 25, 65, 159, false, "Math", "Four");
        Student stThree = new Student("Bruce", "Robertson", 30, 64, 161, true, "Biology", "Two");
        Student stFour = new Student("Cliff", "Birds", 32, 70, 171, true, "Biology", "Two");
        Student stFive = new Student("Daisy", "Nail", 20, 75, 180, false, "Biology", "Three");
        Student stSix = new Student("Nicole", "WilKinson", 21, 80, 185, false, "Math", "Four");
        Student stSeven = new Student("Richard", "Hardman", 34, 79, 157, true, "Biology", "Two");
        Student stEight = new Student("Sarah", "Blare", 30, 68, 163, false, "Math", "Four");
        Student stNine = new Student("Stacey", "Longman", 25, 64, 160, false, "Biology", "Three");
        Student stTen = new Student("Wilma", "Leapman", 27, 77, 170, false, "Math", "Four");


        Student[] mathematic = new Student[]{stOne, stThree, stFour, null, stFive, null, stSeven, stEight, stNine, stTen};
        Group group = new Group(mathematic);
        System.out.println("-----PrintGroup-----noSorting---------------");
        group.PrintGroup(mathematic);

        try {
            SortGroup(mathematic);
        }catch (IllegalArgumentException e){
            setNoNull(group);
            SortGroup(mathematic);
        }
        System.out.println("--------PrintGroup-----Sorting----------------");
        group.PrintGroup(mathematic);

        try{
            group.setStud(new Student("William", "Vatson", 40, 90, 190, true, "Math", "Five"), 1);
            group.setStud(new Student(), 2);
            group.delStud(8);
            System.out.println("=======delStud(8)==============");
            group.getStud(8);
            System.out.println("========setNoNull===========");
            setNoNull(group);

        }catch (ArrayIndexOutOfBoundsException ex){
            System.out.println(" ArrayIndexOutOfBounds ");
        }

        System.out.println("-------print----setNoNull--------------------");
        group.PrintGroup(mathematic);

        System.out.println();
        System.out.println("------findBySurname Longman----------");
        System.out.println(group.findBySurname("Longman"));

    }

    public static Student[] setNoNull(Group group){
        for (Student x: group.getStud1()) {
            if (x == null) {
                group.setStud((new Student("", "", 0, 0, 0, false, "", "")), Arrays.asList(group.getStud1()).indexOf(x));
            }
        }
        return group.getStud1();
    }

    public static void SortGroup(Student[] students) throws IllegalArgumentException{
        for (Student x: students) {
            if (x == null) {
                throw new IllegalArgumentException();
            }
        }
            Arrays.sort(students);
    }
}
