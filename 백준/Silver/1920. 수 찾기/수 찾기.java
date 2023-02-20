import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arrN = new int[N];
		for(int i = 0; i < N; i++) {
			arrN[i] = sc.nextInt();
		}
		
		Arrays.sort(arrN);
		
		int M = sc.nextInt();
		for(int i = 0; i < M; i++) {
			int numM = sc.nextInt();
			if(Arrays.binarySearch(arrN, numM)<0) {
				System.out.println(0);
			} else {
				System.out.println(1);
			}
		}
	}
}
