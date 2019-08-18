package homework10_01_02;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class DictionaryCreator {

	private TreeMap<String, String> dictionary;
	private String pathDictionary;

	public DictionaryCreator() {
	}

	public DictionaryCreator(String pathFrom) {
		this.pathDictionary = pathFrom;
		this.dictionary = new TreeMap<String, String>();
	}

	public TreeMap<String, String> readDictionary() {

		try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(pathDictionary))) {
			dictionary = (TreeMap<String, String>) reader.readObject();
		} catch (IOException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return dictionary;
	}

	public void addNewWord(String word, String translate) {
		word = word.trim().toLowerCase();
		translate = translate.trim().toLowerCase();
		if (dictionary.putIfAbsent(word, translate) != null) {
			writeToFile(word, translate);
		}

	}

	public void writeToFile(String word, String translate) {
		Map<String, String> newDictionary = new TreeMap<String, String>(dictionary);
		try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(pathDictionary))) {
			writer.writeObject(newDictionary);
			writer.flush();
			writer.close();
		} catch (IOException ex) {
		}
	}

	@Override
	public String toString() {
		return "DictionaryCreator{" + "dictionary=" + dictionary + '}';
	}
}