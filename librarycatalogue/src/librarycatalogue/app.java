package librarycatalogue;

import java.util.Scanner;

public class app {

	public static void main(String[] args) {
		
	}
	Paper add(){
		Scanner input = new Scanner(System.in);
		String type = input.next();
		Paper paper = null;
		if(type.equals("book"))
		{
			paper = new Book();
		}else if(type.equals("newspaper")){
			paper = new Newspaper();
		}else if(type.equals("letter")){
			paper=new Letter();
		}else{
			System.out.println("Wrong type of paper.");
		}
		input.close();
		return paper;
	}
}
