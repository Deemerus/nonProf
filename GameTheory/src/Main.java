import java.util.Scanner;

class Player{
	
	int[] strategy;
	
	void setStrategy(int gameLenght){
		Scanner input = new Scanner(System.in);			 //ignore warning
		strategy = new int[gameLenght];
		for(int i=0;i<gameLenght;i++){
			strategy[i]=input.nextInt();
		}
		//input.close();
	}
	
	void printStrategy(int gameLenght){
		for(int i=0;i<gameLenght;i++){
			System.out.print(strategy[i] + " ");
		}
	}
}

class Game{
	int[][] player1Payout;
	int[][] player2Payout;
	
	void setP1Payout(int gameLenght, int gameWidth){
		player1Payout = new int[gameWidth][gameLenght];
		Scanner input = new Scanner(System.in); 		//ignore warning
		for(int i=0;i<gameWidth;i++){
			for(int j=0;j<gameLenght;j++){
				player1Payout[i][j] = input.nextInt();
			}
		}
		//input.close();
	}
	void setP2Payout(int gameLenght, int gameWidth){
		player2Payout = new int[gameWidth][gameLenght];
		Scanner input = new Scanner(System.in); 		//ignore warning
		for(int i=0;i<gameWidth;i++){
			for(int j=0;j<gameLenght;j++){
				player2Payout[i][j] = input.nextInt();
			}
		}
		//input.close();
	}
	
	void printPayout(int gameLenght, int gameWidth){
		for(int i=0;i<gameWidth;i++){
			for(int j=0;j<gameLenght;j++){
				System.out.print(player1Payout[i][j] + "," + player2Payout[i][j] + "\t");
			}
			System.out.println();
		}
	}
}

public class Main {

	public static void main(String[] args) {
		System.out.println("start");
		int lenght, width;
		Game game1 = new Game();
		Player player1 = new Player();
		Player player2 = new Player();
		System.out.println("Enter lenght and width");
		Scanner input = new Scanner(System.in);
		lenght = input.nextInt();
		width = input.nextInt();
		System.out.println("Enter player one payouts");
		game1.setP1Payout(lenght, width);
		System.out.println("Enter player two payouts");
		game1.setP2Payout(lenght, width);
		game1.printPayout(lenght, width);

		System.out.println("stop");
		input.close();
	}

}