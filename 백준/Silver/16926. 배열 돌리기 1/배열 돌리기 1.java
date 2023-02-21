import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		turn(0,0,N-1,M-1);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	private static void turn(int sR, int sC, int eR, int eC) {
		if(sR>=eR || sC>=eC) {
			return;
		}
		
		for(int r = 0; r < R; r++) {
			int temp = arr[sR][sC];
			
			for(int i = sC; i < eC; i++) {
				arr[sR][i] = arr[sR][i+1];
			}
			for(int i = sR; i < eR; i++) {
				arr[i][eC] = arr[i+1][eC];
			}
			for(int i = eC; i > sC; i--) {
				arr[eR][i] = arr[eR][i-1];
			}
			for(int i = eR; i > sR; i--) {
				arr[i][sC] = arr[i-1][sC];
			}
			
			arr[sR+1][sC] = temp;
		}
		
		turn(sR+1, sC+1, eR-1, eC-1);
	}
}
