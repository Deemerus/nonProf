package troops;

public class Archer extends Troop {
	public static int archerCount = 0;
	public static int opArcherCount = 0;
	public Archer() {
		atackType = "ranged";
		ID = archerCount;
		archerCount++;
		count++;
		System.out.println("Archer number " + archerCount + " spawned and has " + atackType + " atack type.");
	}
	public Archer(int a)
	{
		atackType = "melee";
		ID = opArcherCount;
		opArcherCount++;
	}


}
