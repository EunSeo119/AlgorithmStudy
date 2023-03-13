import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
//	static Integer dp[];
//	static int stairs[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] stairs = new int[N+1];
		int[] dp = new int[N+1];
//		stairs = new int[N+1];
//		dp = new Integer[N+1];
		for(int n=1; n <= N; n++) {
			stairs[n] = Integer.parseInt(br.readLine());
		}
		
//		dp[0] = stairs[0];	// static 으로 선언한건 디폴트가 null이므로 0으로 초기화해주어야함
		dp[1] = stairs[1];
		
		if(N>=2) {
			dp[2] = stairs[1] + stairs[2];
		}
		
		// Bottom-Up 방식(반복문)
		for(int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3]+stairs[i-1]) + stairs[i];
		}
		
		System.out.println(dp[N]);
		
//		System.out.println(find(N));
	}
	
//	// Top-Down 방식(재귀)
//	static int find(int N) {
//		// 아직 탐색하지 않는 N번째 계단일 경우
//		if(dp[N] == null) {
//			dp[N] = Math.max(find(N - 2), find(N - 3) + stairs[N - 1]) + stairs[N];
//		}
//		
//		return dp[N];
//	}
}
