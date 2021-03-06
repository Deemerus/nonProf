import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Node {
	private List<Neighbour> neighbours = new ArrayList<Neighbour>();
	private int[] distanceFrom = { 0, 0, 0, 0, 0, 0, 0, 0 };

	public void addNeighbour(Neighbour neighbour) {
		neighbours.add(neighbour);
	}

	public void printNeighbours() {
		for (Neighbour neighbour : neighbours) {
			System.out.println(neighbour.getDistance());
		}
	}

	public void countDistance(Map<Integer, Node> nodes, int pointOfInterest) {
		for (Neighbour neighbour : neighbours) {
			if (nodes.get(neighbour.getID()).distanceFrom[pointOfInterest] == 0
					|| nodes.get(neighbour.getID()).distanceFrom[pointOfInterest] > this.distanceFrom[pointOfInterest]
							+ neighbour.getDistance()) {
				nodes.get(neighbour.getID()).distanceFrom[pointOfInterest] = this.distanceFrom[pointOfInterest]
						+ neighbour.getDistance();
				nodes.get(neighbour.getID()).countDistance(nodes, pointOfInterest);
			}
		}
	}

	public int getDistanceFromPoint(int pointOfInterest) {
		return distanceFrom[pointOfInterest];
	}

	public void findPath(Map<Integer, Node> nodes, int firstNodeID) {
		for (Neighbour neighbour : neighbours) {
			if (nodes.get(neighbour.getID()).distanceFrom[firstNodeID] == this.distanceFrom[firstNodeID]
					- neighbour.getDistance()) {
				System.out.println(neighbour.getID());
				nodes.get(neighbour.getID()).findPath(nodes, firstNodeID);
				return;
			}
		}
	}

}