package knightarcherandfootman;

public class Pikeman extends Troop {
	public Pikeman() {
		atackType="melee";
		ID=count;
		count++;
		System.out.println("Pikeman number " + ID + " spawned and has " + atackType + " atack type.");
		
	}

}
