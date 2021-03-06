import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Maze {
	private int[][] maze;
	private int length;
	private int height;
	List<Node> nodes = new ArrayList<Node>();

	Maze() {
		try (Scanner in = new Scanner(new File("maze.bin"))) {
			this.length = in.nextLine().length();
			int i = 1;
			for (; in.hasNextLine(); i++)
				in.nextLine();
			this.height = i;
		} catch (FileNotFoundException e) {
			System.out.println("File maze.bin not found.");
		}
		this.maze = new int[this.height][this.length];
		try (Scanner in = new Scanner(new File("maze.bin"))) {
			for (int i = 0; in.hasNextLine(); i++) {
				char[] charArray = in.nextLine().toCharArray();
				for (int j = 0; j < charArray.length; j++) {
					if (charArray[j] == '#') {
						maze[i][j] = 0;
					} else {
						maze[i][j] = 1;
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File maze.bin not found.");
		}
	}

	public int getLength() {
		return length;
	}

	public int getHeight() {
		return height;
	}

	boolean checkIfNode(int height, int length) {
		if (maze[height][length] == 1) {
			if (maze[height + 1][length] + maze[height - 1][length] + maze[height][length + 1]
					+ maze[height][length - 1] > 2) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public void setMaze(int height, int length, int value) {
		this.maze[height][length] = value;
	}

	public void addNode(Node node) {
		nodes.add(node);
	}

	public void placeNodesOnMaze() {
		for (Node node : nodes) {
			this.setMaze(node.getHeight(), node.getLength(), -1);
		}
	}

	public void lookForNeighbours() {
		for (Node node : nodes) {
			searchNeighbour(node, node.getHeight(), node.getLength(), 1, 0, 1);
			searchNeighbour(node, node.getHeight(), node.getLength(), -1, 0, 1);
			searchNeighbour(node, node.getHeight(), node.getLength(), 0, 1, 1);
			searchNeighbour(node, node.getHeight(), node.getLength(), 0, -1, 1);
		}
	}

	public void searchNeighbour(Node node, int height, int length, int heightChange, int lengthChange, int distance) {
		if (maze[height + heightChange][length + lengthChange] == -1) {
			node.addNeighbour(height + heightChange, length + lengthChange, distance);
		} else if (maze[height + heightChange][length + lengthChange] == 1) {
			if (heightChange == 0) {
				searchNeighbour(node, height + heightChange, length + lengthChange, 1, 0, distance + 1);
				searchNeighbour(node, height + heightChange, length + lengthChange, -1, 0, distance + 1);
				searchNeighbour(node, height + heightChange, length + lengthChange, 0, lengthChange, distance + 1);
			} else if (lengthChange == 0) {
				searchNeighbour(node, height + heightChange, length + lengthChange, heightChange, 0, distance + 1);
				searchNeighbour(node, height + heightChange, length + lengthChange, 0, 1, distance + 1);
				searchNeighbour(node, height + heightChange, length + lengthChange, 0, -1, distance + 1);
			}
		}
	}
	public void printNodesNeighbours(){
		for(Node node:nodes){
			node.removeNeighbourDuplicates();
			node.printNeighbours();
		}
	}
}
