import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tablature {
	private String[] tab = new String[6];
	private Map<Integer, String> notesValue = new HashMap<Integer, String>();
	private Integer[] stringValue = { 8, 3, 11, 6, 1, 8 };

	Tablature() {
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 6; i++) {
			tab[i] = scanner.nextLine();
		}
		scanner.close();
		notesValue.put(1, "A");
		notesValue.put(2, "A#");
		notesValue.put(3, "B");
		notesValue.put(4, "C");
		notesValue.put(5, "C#");
		notesValue.put(6, "D");
		notesValue.put(7, "D#");
		notesValue.put(8, "E");
		notesValue.put(9, "F");
		notesValue.put(10, "F#");
		notesValue.put(11, "G");
		notesValue.put(0, "G#");
	}

	public void printNotes() {
		for (int i = 0; i < tab[0].length(); i++) {
			for (int j = 0; j < 6; j++) {
				if (Character.isDigit(tab[j].charAt(i))) {
					if (Character.isDigit(tab[j].charAt(i + 1))) {
						System.out.println(notesValue.get((Character.getNumericValue(tab[j].charAt(i)) * 10
								+ Character.getNumericValue(tab[j].charAt(i + 1)) + stringValue[j]) % 12));
					} else {
						System.out.println(
								notesValue.get((Character.getNumericValue(tab[j].charAt(i)) + stringValue[j]) % 12));
					}
				}
			}
		}
	}
}
