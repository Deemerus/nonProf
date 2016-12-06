package knightarcherandfootman;

public class Archer extends Troop {
	public static int archerCount = 0;
	public Archer() {
		atackType = "ranged";
		ID = count;
		count++;
		archerCount++;
		System.out.println("Archer number " + ID + " spawned and has " + atackType + " atack type.");
	}

}
