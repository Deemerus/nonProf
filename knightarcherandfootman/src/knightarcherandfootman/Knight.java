package knightarcherandfootman;

public class Knight extends Troop {
	public static int knightCount = 0;
	public Knight() {
		atackType = "horse";
		ID = count;
		count++;
		knightCount++;
		System.out.println("Knight number " + ID + " spawned and has " + atackType + " atack type.");
	}

}
