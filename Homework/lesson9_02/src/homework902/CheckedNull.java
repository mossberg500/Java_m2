package homework902;

public interface CheckedNull {
	public int NOT_NULL = 7;

	public static int checkNull(Object a, Object b) {
		if (a == null && b != null) {
			return -1;
		}
		if (a != null && b == null) {
			return 1;
		}
		if (a == null && b == null) {
			return 0;
		}
		return NOT_NULL;
	}
}
