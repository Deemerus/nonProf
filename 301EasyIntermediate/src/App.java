import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)){
			String pattern = getPattern(scanner.nextLine());
			try(Scanner scanner2 = new Scanner(new File("enable1.txt"))){
				while(scanner2.hasNextLine()){
					String nextLine = scanner2.nextLine();
					if(nextLine.matches(pattern)){
						System.out.println(nextLine);
					}
				}
			}catch (FileNotFoundException e) {
				System.out.println("File enable1.txt not found.");
			}
		}
	}
	public static String getPattern(String toPattern){
		String pattern = new String();
		Boolean check = false;
		List<Character> chars = new LinkedList<Character>();
		for(int i=0;i<toPattern.length();i++){
			for(int j=0;j<chars.size();j++){
				if(toPattern.charAt(i)==chars.get(j)){
					pattern+="\\" + (j+2);
					check=true;
				}
			}
			if(!check){
				pattern+="(.)";
				chars.add(toPattern.charAt(i));
			}
			check=false;
		}
		return "(.*)"+pattern+"(.*)";
	}
}
