package homework801;

public class studentNotFoundException extends Exception {

	@Override
	public String getMessage() {
		return " Student not found by surname" + '\n';
	}
}
