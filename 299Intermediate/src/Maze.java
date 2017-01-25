import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {
	private int[][] maze;
	private int length;
	private int height;

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
}
