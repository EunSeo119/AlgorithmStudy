import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] numbers, inputs;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		numbers = new int[M];
		inputs = new int[N];
		
		for (int i = 0; i < N; i++) inputs[i] = i+1;
		
		perm(0);
		System.out.println(sb.toString());
	}
	
	private static void perm(int cnt) {
		if(cnt == M) {
			for(int n: numbers) {
				sb.append(n+" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			numbers[cnt] = inputs[i];
			perm(cnt + 1);
		}
	}
}