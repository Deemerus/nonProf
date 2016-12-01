import java.util.Scanner;

class Player{
	
	int[] strategy;
	
	void setStrategy(int gameLenght){
		Scanner input = new Scanner(System.in);
		strategy = new int[gameLenght];
		for(int i=0;i<gameLenght;i++){
			strategy[i]=input.nextInt();
		}
		input.close();
	}
	
	void printStrategy(int gameLenght){
		for(int i=0;i<gameLenght;i++){
			System.out.print(strategy[i] + " ");
		}
	}
}

class Game{
	int[][] player1Payout;
	int[][] player2Paytou;
	
	void setPayout(int gameLenght, int gameWidth, int player){
		
	}
}

public class Main {

	public static void main(String[] args) {
		Player player1 = new Player();
		player1.setStrategy(3);
		player1.printStrategy(3);
		

	}

}