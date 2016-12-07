package troops;

public abstract class Troop {
	protected String atackType = null;
	protected int ID;
	public static int count = 0;

	public int getID() {
		return ID;
	}

	static public void printArmy(boolean a) { // for true returns player army, for false opponents
		if (a == false) {
			System.out.println("Opponents army:");
			System.out.println("Pikeman count: " + Pikeman.opPikemanCount);
			System.out.println("Archer count: " + Archer.opArcherCount);
			System.out.println("Knight count: " + Knight.opKnightCount);
		} else {
			System.out.println("Your army:");
			System.out.println("Pikeman count: " + Pikeman.pikemanCount);
			System.out.println("Archer count: " + Archer.archerCount);
			System.out.println("Knight count: " + Knight.knightCount);
		}
	}
}
