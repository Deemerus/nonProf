package librarycatalogue;

import java.util.Scanner;

public class Letter extends Paper {
	private String author;
	private int date;
	public Letter(){
		id=count;
		count++;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter title.");
		title = input.next();
		System.out.println("Enter author.");
		author = input.next();
		System.out.println("Enter date of release in YYYYMMDD format.");
		date = input.nextInt();
		input.close();
	}
}
