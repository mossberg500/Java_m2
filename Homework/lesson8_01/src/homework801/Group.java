package homework801;

import java.io.Serializable;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class Group implements Conscription, Serializable {
	private static final long serialVersionUID = 1L;
	private Student[] students = new Student[10];
	private String nameGroup;

	public Group(Student[] students, String nameGroup) {
		super();
		this.students = students;
		this.nameGroup = nameGroup;
	}

	public Group(String nameGroup) {
		super();

		this.nameGroup = nameGroup;
	}

	public Group() {
		super();
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	public String getNameGroup() {
		return nameGroup;
	}

	public void setNameGroup(String nameGroup) {
		this.nameGroup = nameGroup;
	}

	// Add student in Group
	public void addStud(Student stud) throws MyException {
		for (int index = 0; index < this.students.length; index++) {
			if (this.students[index] == null
					|| (this.students[index].getName().equals("") || this.students[index].getSurname().equals(""))) {
				this.students[index] = stud;
				this.students[index].setGroup(nameGroup);
				System.out.println("Added" + " student [ " + stud.toString() + " ] to current Group ");
				return;
			}
		}
		throw new MyException();
	}

	public void addStudents() {

		while (true) {
			String input = null;
			// Student stTwo = new Student("Agatha", "MacDonald", 25, 65, 159, false,
			// "Math", "Four");
			input = JOptionPane
					.showInputDialog("Add student in format: name surname age weight growth sex faculty group" + " \n"
							+ " name surname age weight growth sex faculty group");
			if (input == null) {
				break;
			}
			String[] fields = input.split(" ");
			try {
				String name = fields[0];
				String surname = fields[1];
				int age = Integer.valueOf(fields[2]);
				double weight = Double.valueOf(fields[3]);
				double growth = Double.valueOf(fields[4]);
				boolean sex = Boolean.valueOf(fields[5]);
				String faculty = fields[6];
				String group = fields[7];

				Student student = new Student(name, surname, age, weight, growth, sex, group);
				addStud(student);
				System.out.println(student);
				System.out.println("===========================");
			} catch (IndexOutOfBoundsException e1) {
				JOptionPane.showMessageDialog(null, "Input data are incomplete");
				continue;
			} catch (NumberFormatException e3) {
				JOptionPane.showMessageDialog(null, e3.getMessage());
				continue;
			} catch (MyException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				break;
			}
		}
	}

	// Delete student from Group (null)
	public void delStud(int id) throws studentNotFoundException {
		for (int index = 0; index < students.length; index++) {
			if (students[index] != null && students[index].getIdHuman() == id) {
				Student st = students[index];
				students[index] = null;
				System.out.println("" + "Student [ " + st.toString() + " ] was successfully deleted " + '\n');
				return;
			}
		}

	}

	// Find student in Group by surname
	public Student findBySurname(String surname) throws studentNotFoundException {
		String res = "";
		for (Student a : students) {
			if (a != null && a.getSurname().equals(surname)) {
				res += "Seach result :  " + surname + " found: " + "[" + a + "]" + '\n';
				System.out.println(res);
				return a;
			}
		}
		throw new studentNotFoundException();

	}

	public void sortGroup() {
		Student buf;
		boolean isSorted = false;
		while (!isSorted) {
			isSorted = true;
			for (int i = 0; i < students.length - 1; i++) {
				if (students[i] == null && students[i + 1] != null) {
					continue;
				} else if (students[i] == null && students[i + 1] == null) {
					continue;
				} else if (students[i] != null && students[i + 1] == null) {
					isSorted = false;
					buf = students[i];
					students[i] = students[i + 1];
					students[i + 1] = buf;
					continue;
				}
				if (students[i].getSurname().compareToIgnoreCase(students[i + 1].getSurname()) > 0) {
					isSorted = false;
					buf = students[i];
					students[i] = students[i + 1];
					students[i + 1] = buf;
				}
			}

		}
	}

	public void setStudForNottNull(Student stud, int index) throws ArrayIndexOutOfBoundsException {
		if (index < 0 && index > this.students.length - 1)
			throw new ArrayIndexOutOfBoundsException();
		this.students[index] = stud;
	}

	public void setNoNull() {
		for (Student x : students) {
			if (x == null) {
				setStudForNottNull((new Student("", "", 0, 0, 0, false, "")), Arrays.asList(getStudents()).indexOf(x));
			}
		}
	}

	@Override
	public String toString() {
		String str = "";

		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				str += " name null " + " surname null " + "age 0 " + " weight 0 " + " growth 0 " + " sex false "
						+ " group null" + '\n';
				continue;
			}
			str += students[i].toString() + '\n';
		}
		return str;
	}

	@Override
	public Student[] getConscripts() {
		Student[] conscripts = new Student[students.length];
		int i = 0;
		for (Student student : students) {
			if ((student != null) && (student.getAge() >= MILITARY_AGE) && (student.isSex() == true)) {
				conscripts[i] = student;
				i++;
			}
		}
		Arrays.sort(conscripts,
				(a, b) -> CheckedNull.checkNull(a, b) != CheckedNull.NOT_NULL ? CheckedNull.checkNull(a, b)
						: a.getSurname().compareTo(b.getSurname()));
		return conscripts;
	}
}
