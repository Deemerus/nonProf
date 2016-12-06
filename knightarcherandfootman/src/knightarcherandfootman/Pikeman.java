package knightarcherandfootman;

public class Pikeman extends Troop {
	public static int pikemanCount = 0;
	public static int opPikemanCount = 0;
	public Pikeman() {
		atackType = "melee";
		ID = pikemanCount;
		pikemanCount++;
		System.out.println("Pikeman number " + ID + " spawned and has " + atackType + " atack type.");
	}
	public Pikeman(int a)
	{
		atackType = "melee";
		ID = opPikemanCount;
		opPikemanCount++;
	}

}
