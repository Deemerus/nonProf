package librarycatalogue;

import java.util.Scanner;

public class Letter extends Paper {

	public Letter(Scanner input) {
		id = count;
		count++;
		System.out.println("Enter title.");
		title = input.nextLine();
		System.out.println("Enter author.");
		author = input.nextLine();
		System.out.println("Enter date of release in YYYYMMDD format.");
		date = Integer.parseInt(input.nextLine());
	}
}
