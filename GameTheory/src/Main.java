public class Main {

	public static void main(String[] args) {
		System.out.println("start");
		System.out.println("Enter lenght and width");
		Player player1 = new Player();
		Player player2 = new Player();
		System.out.println("Enter player 1 strategy");
		player1.setStrategy();
		System.out.println("Enter player 2 strategy");
		player2.setStrategy();
		System.out.println();
		System.out.println("Enter player one payouts");
		player1.setPayout(player1,player2);
		System.out.println("Enter player two payouts");
		player2.setPayout(player1,player2);
		player1.printPayout(player2);
		player2.printPayout(player1);
		System.out.println("stop");
	}

}