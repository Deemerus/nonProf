public class App {

	public static void main(String[] args) {
		Maze maze = new Maze();
		for(int i=0;i<=7;i++){
			maze.solve(i);
		}
		System.out.println(maze.optimizeDistance());
	}
	
	
}
