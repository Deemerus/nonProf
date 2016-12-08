package librarycatalogue;

import java.util.ArrayList;
import java.util.Scanner;

public class app {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Paper> library = new ArrayList<Paper>();

		library.add(add(input));
		library.add(add(input));
		library.add(add(input));
		remove(library, input);
		System.out.println(library.get(0).getId());
		System.out.println(library.get(1).getId());
		System.out.println(library.get(2).getId());
		
		input.close();
	}

	static Paper add(Scanner input) {
		System.out.println("What kind of paper would you like to add?");
		String type = input.nextLine();
		Paper paper = null;
		if (type.equals("book")) {
			paper = new Book(input);
		} else if (type.equals("newspaper")) {
			paper = new Newspaper(input);
		} else if (type.equals("letter")) {
			paper = new Letter(input);
		} else {
			System.out.println("Wrong type of paper.");
		}
		return paper;
	}
	
	static ArrayList<Paper> remove(ArrayList<Paper> library, Scanner input){
		System.out.println("Type in the ID of book you want to remove from database.");
		int id = input.nextInt();
		library.get(id-1).remove();
		return library;
	}

}
