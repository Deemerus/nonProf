package knightarcherandfootman;

public class Knight extends Troop {
	public static int knightCount = 0;
	public static int opKnightCount = 0;
	public Knight() {
		atackType = "horse";
		ID = knightCount;
		knightCount++;
		System.out.println("Knight number " + ID + " spawned and has " + atackType + " atack type.");
	}
	public Knight(int a)
	{
		atackType = "horse";
		ID = opKnightCount;
		opKnightCount++;
	}


}
