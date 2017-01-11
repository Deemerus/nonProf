import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String string = input.nextLine();
		int state = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == ')') {
				if (state <= 0) {
					System.out.print("*" + string.charAt(i) + "*");
				} else {
					System.out.print(string.charAt(i));
					state--;
				}
			} else if (string.charAt(i) == '(') {
				if (countState(string, i, state) > 0) {
					System.out.print("*" + string.charAt(i) + "*");
				} else {
					state++;
					System.out.print(string.charAt(i));
				}
			} else {
				System.out.print(string.charAt(i));
			}
		}
		input.close();
	}

	static int countState(String string, int index, int state) {
		for (; index < string.length(); index++) {
			if (string.charAt(index) == '(') {
				state++;
			} else if (string.charAt(index) == ')') {
				if (state > 0) {
					state--;
				}
			}
		}
		return state;
	}
}
