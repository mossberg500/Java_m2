package lesson8_02;

public class Main {

	public static void main(String[] args) {
		BlackList blackList = new BlackList();
		Stack st = new Stack(10, blackList);

		String s1 = null;
		String s2 = "Hello";
		String s3 = "and";
		String s4 = "frends";

		Integer integer1 = null;
		Integer integer2 = 5;
		Integer integer3 = 153;
		Integer integer4 = 955;
		Integer integer5 = 101;
		Integer integer6 = 920;

		Boolean boolean1 = true;
		Boolean boolean2 = false;

		// blackList.addToBlackList(integer2);
		blackList.addToBlackList(boolean1);
		// blackList.addToBlackList(s4);

		System.out.println(blackList);
		System.out.println("----------------");
		st.push(boolean1);
		st.push(boolean2);
		st.push(integer3);
		st.push(integer4);
		st.push(integer5);
		st.push(s2);
		st.push(integer3);
		st.push(s4);
		System.out.println(st);

		System.out.println("----------------");
		Object ob = st.receiveIndex();
		System.out.println(ob);

		System.out.println("----------------");
		st.pop();
		System.out.println(st);
		st.pop();
		System.out.println(st);
		st.pop();
		System.out.println(st);
		System.out.println(st);
		st.pop();
		System.out.println(st);
		st.pop();
		System.out.println(st);
		st.pop();
		System.out.println(st);
		st.pop();
		System.out.println(st);

	}

}
