import java.util.ArrayList;
import java.util.List;

public class Node {
	private int height;
	private int length;
	List<Neighbour> neighbours = new ArrayList<Neighbour>();

	Node(int height, int length) {
		this.height = height;
		this.length = length;
	}

	public int getHeight() {
		return height;
	}

	public int getLength() {
		return length;
	}

	public void addNeighbour(int height, int length, int distance) {
		neighbours.add(new Neighbour(height, length, distance));
	}

	public void printNeighbours() {
		System.out.println("Printing neighbours of Node: " + height + " " + length);
		for (Neighbour neighbour : neighbours) {
			neighbour.print();
		}
		System.out.println();
	}

	public void removeNeighbourDuplicates() {
		for (int i = 0; i < neighbours.size()-1; i++) {
			for (int j = i + 1; j < neighbours.size(); j++) {
				if (neighbours.get(i).getHeight() == neighbours.get(j).getHeight()
						&& neighbours.get(i).getLength() == neighbours.get(j).getLength()) {
					if (neighbours.get(i).getDistance() <= neighbours.get(j).getDistance()) {
						neighbours.remove(j);
					} else
						neighbours.remove(i);
				}
			}
		}
	}
}
