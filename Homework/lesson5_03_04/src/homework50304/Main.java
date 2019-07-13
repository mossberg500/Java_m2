package homework50304;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MyException, studentNotFoundException {
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
        Student stEleven = new Student("Adnold", "Lenon", 40, 88, 190, true, "Math", "Two");

        Group group = new Group();
        try {
            group.addStud(stOne);
            group.addStud(stTwo);
            group.addStud(stFour);
            group.addStud(stTen);
       //     group.addStud(stThree);
       //     group.addStud(stNine);
            group.addStud(stFive);
            group.addStud(stEight);
            group.addStud(stThree);
         //   group.addStud(stThree);
            group.addStud(stSeven);
            group.addStud(stEleven);
            group.addStud(stSix);
        } catch (MyException | NullPointerException e) {
            e.printStackTrace();

            if (e instanceof MyException) {
                System.out.println(((MyException) e).getMessage());

            } else {
                System.out.println(" Enter null, added not continue");
            }

        }
        System.out.println("-----PrintGroup-----noSorting---------------");
        System.out.println(group.toString());


        	System.out.println("--------PrintGroup-----Sorting----getSurname------------");
            Arrays.sort(group.getStudents(), (a, b) -> CheckedNull.checkNull(a,b) != CheckedNull.NOT_NULL ? CheckedNull.checkNull(a, b) :
            	a.getSurname().compareTo(b.getSurname()));
            System.out.println(group.toString());

        MilitaryDepartment militaryDepartment = new MilitaryDepartment();
		militaryDepartment.getInfo(group);
		
		System.out.println("----------SaveToFile------");
	
		SaveAndLoadToFile.saveGroup(group);
	  
		System.out.println("----------LoadFromFile------");
		
		Group groupfile = SaveAndLoadToFile.loadGroup("Group.csv");
		System.out.println(groupfile.toString());

		

    }
}