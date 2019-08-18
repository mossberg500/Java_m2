package homework10_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add("one");
		list.add("two");
		list.add("four");
		list.add("three");
		list.add("five");

		List<Boolean> listBoolean = new ArrayList<>();
		listBoolean.add(Boolean.TRUE);
		listBoolean.add(Boolean.FALSE);
		listBoolean.add(Boolean.TRUE);
		listBoolean.add(Boolean.FALSE);
		listBoolean.add(Boolean.TRUE);
		listBoolean.add(Boolean.FALSE);
		listBoolean.add(Boolean.FALSE);
		listBoolean.add(Boolean.FALSE);

		ObjCounter counter = new ObjCounter();
		Map<Character, Integer> counterStringResult = counter.count(list);
		System.out.println("counter String Result  " + counterStringResult);

		Map<Character, Integer> counterBoolResult = counter.count(listBoolean);
		System.out.println("counter Boolean Result  " + counterBoolResult);
	}
}
