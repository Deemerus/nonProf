package knightarcherandfootman;

public class Archer extends Troop {
	public static int archerCount = 0;
	public static int opArcherCount = 0;
	public Archer() {
		atackType = "ranged";
		ID = archerCount;
		archerCount++;
		System.out.println("Archer number " + ID + " spawned and has " + atackType + " atack type.");
	}
	public Archer(int a)
	{
		atackType = "melee";
		ID = opArcherCount;
		opArcherCount++;
	}


}
