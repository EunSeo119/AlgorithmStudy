import java.util.Scanner;

public class Main {
	static int N;
	static int[] inputS, inputB;
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		inputS = new int[N];
		inputB = new int[N];
		
		for(int i = 0; i < N; i++) {
			inputS[i] = sc.nextInt();
			inputB[i] = sc.nextInt();
		}
		
		int tmpS = 0;
		int tmpB = 0;
		for(int i = 0; i < N; i++) {
			tmpS*=inputS[i];
			tmpB+=inputB[i];
		}
		result = Math.max(tmpS, tmpB);
		
		subset();
		System.out.println(result);
	}
	private static void subset() {
		int S;
		int B;
		for (int i = 1; i < (1<<N); ++i) {
			S = 1;
			B = 0;
			for(int j = 0; j < N; ++j) {
				if((i & (1 << j))==0) continue;
				
				S*=inputS[j];
				B+=inputB[j];
			}
			
			result = Math.min(result, Math.abs(S-B));
		}
	}
}
