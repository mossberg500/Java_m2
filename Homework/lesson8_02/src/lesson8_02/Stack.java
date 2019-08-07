package lesson8_02;

import java.util.Arrays;

public class Stack {
	private BlackList blist;
	private int size;
	private Object[] stackObjects;
	private int ind = 0;
	private int lastind = 0;

	public Stack(int size, BlackList blist) {
		super();
		this.size = size;
		this.blist = blist;
		stackObjects = new Object[size];
	}

	private boolean isCorrectIndex(int index) {
		return ((index >= 0) && (index < stackObjects.length) && lastind >= 0);
	}

	private boolean isBlackList(Object obj) {
		for (Class bl : blist.getBlackList()) {
			if (obj.getClass().equals(bl))
				return true;
		}
		return false;
	}

	public void push(Object obj) {
		if (!isCorrectIndex(ind)) {
			System.out.println("Steck is full");
		}
		if (obj != null && !isBlackList(obj)) {
			stackObjects[ind] = obj;
			lastind = ind;
			ind += 1;

		} else if (obj != null) {
			System.out.println("This is variable " + obj.toString() + " in BlackList");
		} else
			System.out.println(" This is object " + " is null");
	}

	public void pop() {
		if (isCorrectIndex(ind)) {
			stackObjects[lastind] = null;
			ind--;
			System.out.println("Remove object with index = " + lastind);
			lastind -= 1;
		} else {
			System.out.println("Array is empty");
		}
	}

	public Object receiveIndex() {
		if (isCorrectIndex(ind)) {
			Object newObject = new Object();
			newObject = stackObjects[lastind];
			System.out.println("\"Return objeck with index = " + lastind);
			return newObject;
		}
		return null;
	}

	@Override
	public String toString() {
		return "Stack " + Arrays.toString(stackObjects) + ".";
	}

}
