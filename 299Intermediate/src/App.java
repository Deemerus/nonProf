import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		List<Node> nodes = new ArrayList<Node>();
		Maze maze = new Maze();
		for (int i = 0; i < maze.getHeight(); i++) {
			for (int j = 0; j < maze.getLength(); j++) {
				if (maze.checkIfNode(i, j)) {
					nodes.add(new Node(i, j));
				}
			}
		}
		System.out.println(nodes.size());
	}
}
