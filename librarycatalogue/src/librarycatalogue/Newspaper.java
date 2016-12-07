package librarycatalogue;

import java.util.Scanner;

public class Newspaper extends Paper {
	private int date;
	public Newspaper(){
		id=count;
		count++;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter title.");
		title = input.next();
		System.out.println("Enter date of release in YYYYMMDD format.");
		date = input.nextInt();
		input.close();
	}
}
