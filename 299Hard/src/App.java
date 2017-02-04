import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int id = 0;
		Map<Integer, Node> nodes = new HashMap<Integer, Node>();
		try (Scanner scanner = new Scanner(new File("graph2"))) {
			while (scanner.hasNext()) {
				int nid = scanner.nextInt() * 1000 + scanner.nextInt();
				String next = scanner.next();
				if (next.equals("-")) {
					id = nid;
					nodes.put(id, new Node());
				} else {
					nodes.get(id).addNeighbour(new Neighbour(nid, Integer.parseInt(next)));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File graph2 not found.");
		}
		int[] pointsOfInterest = new int[8];
		try (Scanner scanner = new Scanner(new File("graph2"))) {
			for (int i = 0; i <= 7; i++) {
				id = scanner.nextInt() * 1000 + scanner.nextInt();
				pointsOfInterest[i] = id;
				nodes.get(id).countDistance(nodes, i);
				scanner.nextLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File graph2 not found.");
		}
		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j <= 7; j++) {
				if (i == j) {
					System.out.print("X ");
				} else
					System.out.print(nodes.get(pointsOfInterest[j]).getDistanceFromPoint(i) + " ");
			}
			System.out.println();
		}
		System.out.println(pointsOfInterest[0]);
		nodes.get(pointsOfInterest[0]).findPath(nodes, 1);
		System.out.println(pointsOfInterest[1]);
	}
}