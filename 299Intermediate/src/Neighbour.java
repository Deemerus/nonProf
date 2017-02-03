
public class Neighbour {
	private int height;
	private int length;
	private int distance;

	Neighbour(int height, int length, int distance) {
		this.height = height;
		this.length = length;
		this.distance = distance;
	}

	public int getHeight() {
		return height;
	}

	public int getLength() {
		return length;
	}

	public int getDistance() {
		return distance;
	}

	public void print() {
		System.out.println(height + " " + length + " " + distance);
	}
}
