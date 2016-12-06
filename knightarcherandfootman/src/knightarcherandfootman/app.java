package knightarcherandfootman;

import java.util.ArrayList;
import java.util.Scanner;

public class app {

	public static void main(String[] args) {
		ArrayList<Troop> army = new ArrayList<Troop>();
		@SuppressWarnings("resource")
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
				} else System.out.println("Incorrect command");
			} else if (action.equals("army")) {
				for (Troop troop : army) {
					System.out.println("Troop number: " + troop.getID());
				}

			} else if (action.equals("spawnPikeman")) {
				army.add(new Pikeman());
			}

			else {
				System.out.println("wrong command");
			}
			
		}

	}

}
