
public class App {

	public static void main(String[] args) {

		Maze maze = new Maze();
		for (int i = 0; i < maze.getHeight(); i++) {
			for (int j = 0; j < maze.getLength(); j++) {
				if (maze.checkIfNode(i, j)) {
					maze.addNode(new Node(i, j));
				}
			}
		}
		maze.placeNodesOnMaze();
		maze.lookForNeighbours();
		maze.printNodesNeighbours();
	}
}
