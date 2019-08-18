package homework10_01_02;

import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		String from = "folderOne\\English_in.txt";
		String to = "folderOne\\Ukrainian_out.txt";

		DictionaryCreator creater = new DictionaryCreator("folderOne\\dictionary.txt");
		TreeMap<String, String> map = creater.readDictionary();

		creater.addNewWord("this", "��");
		creater.addNewWord("morning", "�����");
		creater.addNewWord("is", "�");
		creater.addNewWord("making", "������");
		creater.addNewWord("peanut", "������");
		creater.addNewWord("butter", "�����");
		creater.addNewWord("and", "i");
		creater.addNewWord("cheese", "���");
		creater.addNewWord("sandwiches", "����������");
		creater.addNewWord("the", " ");
		creater.addNewWord("childrens", "������");
		creater.addNewWord("favorite", "���������");
		System.out.println(creater);

		Translator t = new Translator(map, from, to);
		t.translate();
	}
}
