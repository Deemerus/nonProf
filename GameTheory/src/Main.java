import java.util.Scanner;

class Player{
	
	private double[] strategy;
	private double[][] payout;
	Player(int gameLenght){
		Scanner input = new Scanner(System.in);			 //ignore warning
		strategy = new double[gameLenght];
		for(int i=0;i<gameLenght;i++){
			strategy[i]=input.nextDouble();
		}
		//input.close();
	}
	void setPayout(int gameLenght, int gameWidth){
		payout = new double[gameWidth][gameLenght];
		Scanner input = new Scanner(System.in); 		//ignore warning
		for(int i=0;i<gameWidth;i++){
			for(int j=0;j<gameLenght;j++){
				payout[i][j] = input.nextDouble();
			}
		}
	}
	void printStrategy(int gameLenght){
		for(int i=0;i<gameLenght;i++){
			System.out.print(strategy[i] + " ");
		}
	}
	void printPayout(Player player1, Player player2, int lenght, int width){
		double playerPayout=0;
		for(int i=0;i<lenght;i++){
			for(int j=0;j<width;j++){
				playerPayout=playerPayout+player1.strategy[j]*player2.strategy[i]*player1.payout[i][j];
			}
		}
		System.out.println(playerPayout);
	}
}

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