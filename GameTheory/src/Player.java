import java.util.Scanner;

public class Player{
	
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
