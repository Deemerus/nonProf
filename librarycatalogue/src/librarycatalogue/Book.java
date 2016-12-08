package librarycatalogue;

import java.util.Scanner;

public class Book extends Paper {

	public Book(Scanner input) {
		count++;
		id = count;
		System.out.println("Enter title.");
		title = input.nextLine();
		System.out.println("Enter author.");
		author = input.nextLine();
		System.out.println("Enter ISBN number.");
		ISBN = Integer.parseInt(input.nextLine());
		System.out.println("Enter year of release");
		date = Integer.parseInt(input.nextLine()) * 10000;
	}

	public Book(String title, String author, int ISBN, int date) {
		this.title = title;
		this.author = author;
		this.date = date;
		this.ISBN = ISBN;
		count++;
		id = count;
	}
}
