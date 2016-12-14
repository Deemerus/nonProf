package librarycatalogue;

import java.util.Scanner;

public class Newspaper extends Paper {

	private static final long serialVersionUID = -1596812180066421007L;

	public Newspaper(Scanner input) {
		count++;
		id = count;
		System.out.println("Enter title.");
		title = input.nextLine();
		System.out.println("Enter date of release in YYYYMMDD format.");
		date = Integer.parseInt(input.nextLine());
	}

	public Newspaper(String title, int date) {
		this.title = title;
		this.date = date;
		count++;
		id = count;
	}
}
