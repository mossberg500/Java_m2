package homework10_01_02;

import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		String from = "folderOne\\English_in.txt";
		String to = "folderOne\\Ukrainian_out.txt";

		DictionaryCreator creater = new DictionaryCreator("folderOne\\dictionary.txt");
		TreeMap<String, String> map = creater.readDictionary();

		creater.addNewWord("this", "це");
		creater.addNewWord("morning", "ранок");
		creater.addNewWord("is", "Ї");
		creater.addNewWord("making", "робить");
		creater.addNewWord("peanut", "арах≥с");
		creater.addNewWord("butter", "масло");
		creater.addNewWord("and", "i");
		creater.addNewWord("cheese", "сир");
		creater.addNewWord("sandwiches", "бутерброди");
		creater.addNewWord("the", " ");
		creater.addNewWord("childrens", "дит€ч≥");
		creater.addNewWord("favorite", "улюблений");
		System.out.println(creater);

		Translator t = new Translator(map, from, to);
		t.translate();
	}
}
