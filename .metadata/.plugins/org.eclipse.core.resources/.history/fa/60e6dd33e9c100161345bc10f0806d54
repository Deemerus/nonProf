package librarycatalogue;

import java.util.Scanner;

public class Letter extends Paper {

	public Letter(Scanner input) {
		count++;
		id = count;
		System.out.println("Enter title.");
		title = input.nextLine();
		System.out.println("Enter author.");
		author = input.nextLine();
		System.out.println("Enter date of release in YYYYMMDD format.");
		date = Integer.parseInt(input.nextLine());
	}

	public Letter(String title, String author, int date) {
		this.title = title;
		this.author = author;
		this.date = date;
		count++;
		id = count;
	}
}
