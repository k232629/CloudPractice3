import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		Dictionary.createDictionary();
		Dictionary.kGram();
		Dictionary.permutationIndex();
		while (true) {
			while (true) {
				System.out.println("Enter the word you want to find: ");
				String word = sc.next();
				if (word.equals("")) {
					System.out.println("Enter the word: ");
				}
				for (String st : Dictionary.searchDictionary.query(word)) {
					System.out.println(st +" - in files " + Dictionary.st.get(st));
				}
			}

		}

	}
}
