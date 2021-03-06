import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {
	private int[][] maze;
	private int length;
	private int height;
	private int pointsOfInterest[][] = new int[8][2];
	private int distance[][] = new int[8][8];

	Maze() {
		try (Scanner in = new Scanner(new File("maze.bin"))) {
			this.length = in.nextLine().length();
			int i = 1;
			for (; in.hasNextLine();) {
				char[] charArray = in.nextLine().toCharArray();
				for (int j = 0; j < charArray.length; j++) {
					if ((int) charArray[j] >= 48 && (int) charArray[j] <= 57) {
						this.pointsOfInterest[(int) charArray[j] - 48][0] = i;
						this.pointsOfInterest[(int) charArray[j] - 48][1] = j;
					}
				}
				i++;
			}
			this.height = i;
		} catch (FileNotFoundException e) {
			System.out.println("File maze.bin not found.");
		}
	}

	public void solve(int startPoint) {
		this.maze = new int[this.height][this.length];
		try (Scanner in = new Scanner(new File("maze.bin"))) {
			for (int i = 0; in.hasNextLine(); i++) {
				char[] charArray = in.nextLine().toCharArray();
				for (int j = 0; j < charArray.length; j++) {
					if (charArray[j] == '#') {
						maze[i][j] = -1;
					} else {
						maze[i][j] = 0;
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File maze.bin not found.");
		}
		step(this.pointsOfInterest[startPoint][0], this.pointsOfInterest[startPoint][1]);
		for (int i = 1; i <= 7; i++) {
			this.distance[startPoint][i] = this.maze[this.pointsOfInterest[i][0]][this.pointsOfInterest[i][1]];
		}
	}

	public void step(int height, int length) {
		if (maze[height + 1][length] == 0 || maze[height + 1][length] > maze[height][length] + 1) {
			maze[height + 1][length] = maze[height][length] + 1;
			step(height + 1, length);
		}
		if (maze[height - 1][length] == 0 || maze[height - 1][length] > maze[height][length] + 1) {
			maze[height - 1][length] = maze[height][length] + 1;
			step(height - 1, length);
		}
		if (maze[height][length + 1] == 0 || maze[height][length + 1] > maze[height][length] + 1) {
			maze[height][length + 1] = maze[height][length] + 1;
			step(height, length + 1);
		}
		if (maze[height][length - 1] == 0 || maze[height][length - 1] > maze[height][length] + 1) {
			maze[height][length - 1] = maze[height][length] + 1;
			step(height, length - 1);
		}
	}

	public int optimizeDistance() {
		int optDistance = 1000;
		for (int a1 = 1; a1 <= 7; a1++) {
			for (int a2 = 1; a2 <= 7; a2++) {
				if (a2 != a1) {
					for (int a3 = 1; a3 <= 7; a3++) {
						if (a3 != a1 && a3 != a2) {
							for (int a4 = 1; a4 <= 7; a4++) {
								if (a4 != a1 && a4 != a2 && a4 != a3) {
									for (int a5 = 1; a5 <= 7; a5++) {
										if (a5 != a1 && a5 != a2 && a5 != a3 && a5 != a4) {
											for (int a6 = 1; a6 <= 7; a6++) {
												if (a6 != a1 && a6 != a2 && a6 != a3 && a6 != a4 && a6 != a5) {
													for (int a7 = 1; a7 <= 7; a7++) {
														if (a7 != a1 && a7 != a2 && a7 != a3 && a7 != a4 && a7 != a5
																&& a7 != a6) {
															if (this.distance[0][a1] + this.distance[a1][a2]
																	+ this.distance[a2][a3] + this.distance[a3][a4]
																	+ this.distance[a4][a5] + this.distance[a5][a6]
																	+ this.distance[a6][a7] < optDistance) {
																optDistance = this.distance[0][a1]
																		+ this.distance[a1][a2] + this.distance[a2][a3]
																		+ this.distance[a3][a4] + this.distance[a4][a5]
																		+ this.distance[a5][a6] + this.distance[a6][a7];
															}
														}

													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return optDistance;
	}
}
