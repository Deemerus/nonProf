import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int pairs;
		int count = 1;
		Scanner input = new Scanner(System.in);
		pairs = input.nextInt();
		input.close();
		int[] array = new int[pairs * 2];
		array[0] = 1;
		for (int i = 1; i < array.length; i++) {
			if (count % 2 == 0) {
				count += 2;
			}
			count++;
			array[i] = count;
		}
		count = 0;
		for(int i=1;i<array.length-1;i++){
			for(int j=i+1;j<array.length;j++){
				exchange(array,i,j);
				if(check(array)){
					count++;
				}
			}
		}
		System.out.println(count);
	}

	public static boolean check(int[] array) {
		if (array[0] == array[array.length - 1] + 1 | array[0] == array[array.length - 1] - 1) {
			return false;
		}
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] == array[i + 1] + 1 | array[i] == array[i + 1] - 1) {
				return false;
			}
		}
		return true;
	}

	public static void exchange(int[] array, int x) {
		for(int y=x+1;y<array.length;y++){
			exchange(array,x,y);
			if(check(array)){
				count++;
			}
		}
	}
	
	public static void print(int[] array){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]);
		}
	}

}
