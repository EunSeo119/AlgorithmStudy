
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int mult1 = 1;
		int mult2 = 1;
		for(int i = 0; i < K; i++) {
			mult1*=(N-i);
		}
		for(int i = 1; i <= K; i++) {
			mult2*=i;
		}
		System.out.println(mult1/mult2);
	}
}