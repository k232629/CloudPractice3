import java.util.*;

public class SearchDictionary {
	// Map <String, TreeSet> map;
	TreeSet<String> dictitionary;
	TreeSet<String> rezult;
	String query;

	public SearchDictionary() {
		dictitionary = new TreeSet<String>();

	}

	public void addWord(String word) {
		dictitionary.add(word);
	}

	public void delWord(String word) {
		dictitionary.remove(word);
	}

	public boolean hasWord(String word) {
		return dictitionary.contains(word);
	}

	public int countWords() {
		return dictitionary.size();
	}

	public void getRez(String str) {
		rezult = new TreeSet();
		String temp = str.substring(0, str.length() - 1);
		Iterator it = dictitionary.iterator();
		while (it.hasNext()) {
			String current = (String) it.next();
			if (current.startsWith(temp)) {
				rezult.add(current);
				it.next();
			}
		}
	}

	public Iterable<String> query(String query) {
		rezult = new TreeSet();
		String temp;
		String check = query.substring(query.length()-1,query.length());
		if(check.equals("*")){
			temp = query.substring(0, query.length() - 1);
		}else{
		temp = query;
		}
		//System.out.println("temp = " + temp);
		Iterator it = dictitionary.iterator();
		String current;
		while (it.hasNext()) {
			current = (String) it.next();
			if (current.startsWith(temp)) {
				rezult.add(current);
			}
		}
		if(rezult.size()==0){
			System.out.println("There is no such word in the dictitionary");
		}
		return rezult;
	}

}

