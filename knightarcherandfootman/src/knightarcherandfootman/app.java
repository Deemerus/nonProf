package knightarcherandfootman;

import java.util.ArrayList;
import java.util.Scanner;

public class app {

	public static void main(String[] args) {
		ArrayList<Troop> army = new ArrayList<Troop>();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		for (;;) {
			System.out.println("Type you action.");
			String action = input.next();
			System.out.println(action);
			if (action.equals("spawn")) {
				army.add(new Troop());
			} else if (action.equals("army")) {
				for (Troop troop : army) {
					System.out.println("Troop number: " + troop.getID());
				}

			}

			else {
				System.out.println("wrong command");
			}

		}

	}

}
