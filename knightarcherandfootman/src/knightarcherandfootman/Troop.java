package knightarcherandfootman;

public class Troop {
	private String atackType;
	private int speed;
	private int ID;
	public static int count = 0;

	public Troop() {
		ID=count;
		count++;
		System.out.println("Troop number " + ID + " spawned.");
	}

	public int getID() {
		return ID;
	}

}
