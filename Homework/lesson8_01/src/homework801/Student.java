package homework801;

import java.io.Serializable;

public class Student extends Human implements Serializable {
	private static final long serialVersionUID = 1L;
	private String group;

	public Student(String name, String surname, int age, double weight, double growth, boolean sex, String group) {
		super(name, surname, age, weight, growth, sex);
		this.group = group;
	}

	public Student() {
		super();
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "Student{" + ", group='" + group + '\'' + "} " + super.toString();
	}
}
