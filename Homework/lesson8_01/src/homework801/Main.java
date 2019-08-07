package homework801;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws MyException, studentNotFoundException {
		Student stOne = new Student("Ivan", "Ivanov", 22, 60, 170, true, "Three");
		Student stTwo = new Student("Agatha", "MacDonald", 25, 65, 159, false, "Four");
		Student stThree = new Student("Bruce", "Robertson", 30, 64, 161, true, "Two");
		Student stFour = new Student("Cliff", "Birds", 32, 70, 171, true, "Two");
		Student stFive = new Student("Daisy", "Nail", 20, 75, 180, false, "Three");
		Student stSix = new Student("Nicole", "WilKinson", 21, 80, 185, false, "Four");
		Student stSeven = new Student("Richard", "Hardman", 34, 79, 157, true, "Two");
		Student stEight = new Student("Sarah", "Blare", 30, 68, 163, false, "Four");
		Student stNine = new Student("Stacey", "Longman", 25, 64, 160, false, "Three");
		Student stTen = new Student("Wilma", "Leapman", 27, 77, 170, false, "Four");
		Student stEleven = new Student("Adnold", "Lenon", 40, 88, 190, true, "Two");

		Group groupOne = new Group("One");
		Group groupTwo = new Group("Two");
		Group groupThree = new Group("Three");
		try {
			groupOne.addStud(stOne);
			groupOne.addStud(stTwo);
			groupThree.addStud(stFour);
			groupOne.addStud(stTen);
			groupOne.addStud(stFive);
			groupTwo.addStud(stEight);
			groupOne.addStud(stThree);
			groupTwo.addStud(stSeven);
			groupOne.addStud(stEleven);
			groupOne.addStud(stSix);
		} catch (MyException | NullPointerException e) {
			e.printStackTrace();

			if (e instanceof MyException) {
				System.out.println(((MyException) e).getMessage());

			} else {
				System.out.println(" Enter null, added not continue");
			}

		}
		System.out.println("----------------------Serializable--------------------------------------------");
		Faculty faculty = new Faculty("Math");
		faculty.addInFaculty(groupOne);
		faculty.addInFaculty(groupTwo);
		// faculty.addInFaculty(groupThree);

		faculty.saveGroupToDB();
		System.out.println();
		faculty.clearFaculty();
		System.out.println(faculty.toString());
		System.out.println();
		faculty.loadDB("One.txt");
		System.out.println();
		System.out.println(faculty.toString());
		System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _");

		faculty.loadDB("Two.txt");
		System.out.println();
		System.out.println(faculty.toString());
		System.out.println("----------------------Serializable--------------------------------------------");

//		System.out.println("-----PrintGroup-----noSorting---------------");
//		System.out.println(groupOne.toString());
//
//		System.out.println("--------PrintGroup-----Sorting----getSurname------------");
//		Arrays.sort(groupOne.getStudents(),
//				(a, b) -> CheckedNull.checkNull(a, b) != CheckedNull.NOT_NULL ? CheckedNull.checkNull(a, b)
//						: a.getSurname().compareTo(b.getSurname()));
//		System.out.println(groupOne.toString());
//		MilitaryDepartment militaryDepartment = new MilitaryDepartment();
//		militaryDepartment.getInfo(groupOne);
//		System.out.println("----------SaveToFile------");
//		SaveAndLoadToFile.saveGroup(groupOne);
//		System.out.println("----------LoadFromFile------");
//		Group groupfile = SaveAndLoadToFile.loadGroup("GroupOne.csv");
//		System.out.println(groupfile.toString());

	}
}