package homework10_03;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjCounter<T> {

	private List<T> objects;
	private Map<T, Integer> result;

	public ObjCounter() {
		super();
	}

	public ObjCounter(List<T> objects) {
		super();
		this.objects = objects;
	}

	public List<T> getObjects() {
		return objects;
	}

	public void setObjects(List<T> objects) {
		this.objects = objects;
	}

	public Map<T, Integer> getResult() {
		return result;
	}

	public void setResult(Map<T, Integer> result) {
		this.result = result;
	}

	public Map<T, Integer> count(List<T> objects) {
		result = new HashMap<>();
		for (Object t : objects) {
			Integer quantity = result.get(t);
			if (quantity != null) {
				result.put((T) t, quantity += 1);
			} else {
				result.put((T) t, 1);
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return "ObjCounter{" + "objects=" + objects + ", result=" + result + '}';
	}
}
