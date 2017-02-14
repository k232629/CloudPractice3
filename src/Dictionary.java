import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

import ua.princeton.lib.In;
import ua.princeton.lib.StdIn;
import ua.princeton.lib.StdOut;

public class Dictionary {
	static String Docs[] = { "test1", "test2", "test3", "test4", "test5" };
	static SearchDictionary searchDictionary = new SearchDictionary();
	static ST<String, SET<String>> st = new ST<String, SET<String>>(); 
	static ArrayList<String> dictionary = new ArrayList<String>();
	static ArrayList<String> kgrams = new ArrayList<String>();
	static ArrayList<String> permutations = new ArrayList<String>();
	static ArrayList<String> kgramsWords = new ArrayList<String>();
	static BTree<String, ArrayList<String>> kGram = new BTree<String, ArrayList<String>>();
	static BTree<String, ArrayList<String>> permut = new BTree<String, ArrayList<String>>();

	public static void createDictionary() throws FileNotFoundException { // dictionary

		for (String filename : Docs) {
			Scanner in = new Scanner(new FileReader(filename));

			while (in.hasNext()) {
				String word = in.next();
				word = word.toLowerCase();
				word = word.replaceAll("[^a-zA-Z0-9\\s]", "");
				if (!st.contains(word)){
					st.put(word, new SET<String>());
					searchDictionary.addWord(word);
				}

				SET<String> set = st.get(word);
				set.add(filename);
			 for (String s : st.keys())
				System.out.println((s + "--" + st.get(s)));

			}

		}

	}

	public static void kGram() { // к-грамний індекс
		String part;
		for (String s : st.keys()) {
			String three_word = "$" + s + "$";
			// System.out.println(three_word + "--");
			for (int i = 3, k = 0; i <= three_word.length(); i++, k++) {
				part = three_word.substring(k, i);
				kgrams.add(part);
			

			}

		}
		System.out.println(kgrams.toString());

	}

	public static void permutationIndex() { //перестановочний індекс
		String part;
		for (String s : st.keys()) {
			String word = s;
			String tempChange;
			char[] symbols = word.toCharArray();
			word = s + "$";
			permutations.add(word);
			for (int j = 0; j + 1 < symbols.length; j++) {
				tempChange = word.substring(j + 1, symbols.length) + "$" + word.substring(0, j + 1);
				permutations.add(tempChange);
				// System.out.println(tempChange);
			}
			String lastChange = "$" + word;
			permutations.add(lastChange);
			

		}
		System.out.println(permutations.toString());
	}

}