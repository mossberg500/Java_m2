package lesson8_02;

import java.util.ArrayList;
import java.util.List;

public class BlackList {

	private List<Class> blackList = new ArrayList<>();

	public BlackList() {
	}

	public List<Class> getBlackList() {
		return blackList;
	}

	public void addToBlackList(Object object) {
		if (!contain(object)) {
			blackList.add(object.getClass());
		}
	}

	public void remove(Object object) {
		if (contain(object) && (object != null)) {
			blackList.remove(object.getClass());
		}

	}

	public boolean contain(Object object) {
		if (object == null)
			return true;
		Class<?> objectClass = object.getClass();
		return blackList.contains(objectClass);
	}

	@Override
	public String toString() {
		return "BlackList [" + blackList + "]";
	}

}