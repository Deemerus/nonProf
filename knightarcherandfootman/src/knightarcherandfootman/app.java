package knightarcherandfootman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import troops.Archer;
import troops.Knight;
import troops.Pikeman;
import troops.Troop;

public class app {

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Troop> army = new ArrayList<Troop>();
		ArrayList<Troop> opArmy = readEnemyArmy();
		Troop.printArmy(false);
		Scanner input = new Scanner(System.in);
		for (;;) {
			System.out.println("Type your command.");
			String action = input.next();
			
			if (action.equals("spawn")) {
				System.out.println("What kind of troop would you like to spawn.");
				String troop = input.next();
				if(troop.equals("pikeman")) {
					army.add(new Pikeman());
				} else if(troop.equals("knight")){
					army.add(new Knight());
				} else if(troop.equals("archer")){
					army.add(new Archer());
				} else {
					System.out.println("Incorrect command");
				}
	
			} else if (action.equals("army")) {
				Troop.printArmy(true);
			} else if (action.equals("close")){
				break;
			} else {
				System.out.println("wrong command");
			}
		}
		input.close();
	}
public static ArrayList<Troop> readEnemyArmy() throws FileNotFoundException{
	ArrayList<Troop> opArmy = new ArrayList<Troop>();
	String fileName = "AIarmy.txt";
	File textFile = new File(fileName);
	Scanner in = new Scanner(textFile);
	while(in.hasNextLine()){
		String line = in.nextLine();
		if(line.equals("pikeman")) {
			opArmy.add(new Pikeman(0));
		} else if(line.equals("knight")){
			opArmy.add(new Knight(0));
		} else if(line.equals("archer")){
			opArmy.add(new Archer(0));
		}
	}
	in.close();
	return opArmy;
}

}
