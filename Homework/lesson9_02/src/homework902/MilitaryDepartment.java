package homework902;

public class MilitaryDepartment {
	public void getInfo(Conscription students) {
		Student[] conscripts = students.getConscripts();
		StringBuilder stringBuilder = new StringBuilder("conscripts: \n");
		for (Student student : conscripts) {
			if (student != null) {
				stringBuilder.append(student + "\n");
			}
		}
		System.out.println(stringBuilder.toString());
	}

}
