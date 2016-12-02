import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		System.out.println("start");
		int lenght, width;
		System.out.println("Enter lenght and width");
		Scanner input = new Scanner(System.in);
		lenght = input.nextInt();
		width = input.nextInt();
		System.out.println("Enter player 1 strategy");
		Player player1 = new Player(lenght);
		System.out.println("Enter player 2 strategy");
		Player player2 = new Player(width);
		System.out.println();
		System.out.println("Enter player one payouts");
		player1.setPayout(lenght, width);
		System.out.println("Enter player two payouts");
		player2.setPayout(lenght, width);
		player1.printPayout(player1, player2, lenght, width);
		player2.printPayout(player2, player1, lenght, width);
		System.out.println("stop");
		input.close();
	}

}