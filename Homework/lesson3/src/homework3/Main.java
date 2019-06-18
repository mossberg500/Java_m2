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


        Student[] matematic = new Student[]{stOne, stThree, stFour, null, stFive, null, stSeven, stEight, stNine, stTen};
        Group group = new Group(matematic);
        group.PrintGroup(matematic);
        System.out.println("--------------------------");
        System.out.println(Arrays.asList(matematic).indexOf(stFour));
        System.out.println("--------------------------");

        try {
            Arrays.sort(matematic);
        }catch (NullPointerException e){
            System.out.println(" Объект null Main");
            for (Student x: matematic) {
                if (x == null) {
                   group.setStud((new Student("", "", 0, 0, 0, false, "", "")), Arrays.asList(matematic).indexOf(x));
                }
            }

            Arrays.sort(matematic);
        }



        group.PrintGroup(matematic);






    }
}
