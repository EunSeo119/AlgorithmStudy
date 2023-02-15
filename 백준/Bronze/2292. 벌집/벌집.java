import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int count = 1;
		int temp = 1;
		int result = 1;
		while(temp < N) {
			result++;
			temp = temp+(6*count);
			count++;
		}
		
		System.out.println(result);
	}
}
