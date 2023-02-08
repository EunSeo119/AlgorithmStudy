import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] inputs, numbers;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		inputs = new int[N];
		numbers = new int[M];
		
		for(int i = 0; i < N; i++) {
			inputs[i]=i+1;
		}
		
		comb(0, 0);
	}
	
	private static void comb(int cnt, int start) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i < N; i++) {
			numbers[cnt] = inputs[i];
			comb(cnt+1, i+1);
		}
	}
}
