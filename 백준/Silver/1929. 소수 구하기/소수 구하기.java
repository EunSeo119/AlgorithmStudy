import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		boolean[] isNotPrime = new boolean[N+1];
		
		isNotPrime[0] = true;
		isNotPrime[1] = true;
		for(int i = 2; Math.pow(i, 2) <= N; i++) {
			if(isNotPrime[i] == false) {
				for(int j = 2; i * j <= N; j++ ) {
					isNotPrime[i*j] = true;
				}
			}
		}
		
		for(int i = M; i <= N; i++) {
			if(isNotPrime[i]==false) {
				sb.append(i+"\n");
			}
		}
		System.out.println(sb);
	}
}
