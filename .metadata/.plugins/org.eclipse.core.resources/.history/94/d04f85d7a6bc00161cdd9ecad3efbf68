package librarycatalogue;
import java.util.ArrayList;
import java.util.Scanner;

public class Book extends Paper {
	private int ISBN;
	private String author;
	public Book(){
		id=count;
		count++;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter ISBN number.");
		ISBN = input.nextInt();
		System.out.println("Enter title.");
		title = input.next();
		System.out.println("Enter author.");
		author = input.next();
		System.out.println("Enter year of release");
		date = input.nextInt()*10000;
		input.close();
	}
}
