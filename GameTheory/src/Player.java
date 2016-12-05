import java.util.Scanner;

public class Player{
	private int noOfStrategies;
	private double[] strategy;
	private double[][] payout;
	Player(){
		Scanner input = new Scanner(System.in);			//ignore warning
		this.noOfStrategies = input.nextInt();
	}
	int getNoOfStrategies()
	{
		return noOfStrategies;
	}
	void setStrategy(){
		Scanner input = new Scanner(System.in);			 //ignore warning
		strategy = new double[noOfStrategies];
		for(int i=0;i<noOfStrategies;i++){
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
	void printPayout(Player player2){
		double playerPayout=0;
		for(int i=0;i<player2.getNoOfStrategies();i++){
			for(int j=0;j<getNoOfStrategies();j++){
				playerPayout=playerPayout+this.strategy[j]*player2.strategy[i]*this.payout[i][j];
			}
		}
		System.out.println(playerPayout);
	}
}
