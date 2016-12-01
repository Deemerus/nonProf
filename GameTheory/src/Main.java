import java.util.Scanner;

class Player{
	
	double[] strategy;
	
	void setStrategy(int gameLenght){
		Scanner input = new Scanner(System.in);			 //ignore warning
		strategy = new double[gameLenght];
		for(int i=0;i<gameLenght;i++){
			strategy[i]=input.nextDouble();
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
	double[][] player1Payout;
	double[][] player2Payout;
	
	void setP1Payout(int gameLenght, int gameWidth){
		player1Payout = new double[gameWidth][gameLenght];
		Scanner input = new Scanner(System.in); 		//ignore warning
		for(int i=0;i<gameWidth;i++){
			for(int j=0;j<gameLenght;j++){
				player1Payout[i][j] = input.nextDouble();
			}
		}
		//input.close();
	}
	void setP2Payout(int gameLenght, int gameWidth){
		player2Payout = new double[gameWidth][gameLenght];
		Scanner input = new Scanner(System.in); 		//ignore warning
		for(int i=0;i<gameWidth;i++){
			for(int j=0;j<gameLenght;j++){
				player2Payout[i][j] = input.nextDouble();
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

class StrategyPayouts{
	void printPlayer1Payout(Player player1, Player player2, Game game, int lenght, int width){
		double player1Payout=0;
		for(int i=0;i<lenght;i++){
			for(int j=0;j<width;j++){
				player1Payout=player1Payout+player1.strategy[j]*player2.strategy[i]*game.player1Payout[i][j];
			}
		}
		System.out.println(player1Payout);
	}
	void printPlayer2Payout(Player player1, Player player2, Game game, int lenght, int width){
		double player1Payout=0;
		for(int i=0;i<lenght;i++){
			for(int j=0;j<width;j++){
				player1Payout=player1Payout+player1.strategy[j]*player2.strategy[i]*game.player2Payout[i][j];
			}
		}
		System.out.println(player1Payout);
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
		System.out.println("Enter player 1 strategy");
		player1.setStrategy(lenght);
		System.out.println("Enter player 2 strategy");
		player2.setStrategy(width);
		System.out.println();
		StrategyPayouts payout = new StrategyPayouts();
		payout.printPlayer1Payout(player1, player2, game1, lenght, width);
		payout.printPlayer2Payout(player1, player2, game1, lenght, width);
		System.out.println("stop");
		input.close();
	}

}