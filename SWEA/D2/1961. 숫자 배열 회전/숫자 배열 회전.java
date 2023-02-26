import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int t = 1; t <= T; t++) {
            sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[][] result_90 = Rotation(arr);
			int[][] result_180 = Rotation(result_90);
			int[][] result_270 = Rotation(result_180);
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					sb.append(result_90[i][j]);
				}
				sb.append(" ");
				for(int j = 0; j < N; j++) {
					sb.append(result_180[i][j]);
				}
				sb.append(" ");
				for(int j = 0; j < N; j++) {
					sb.append(result_270[i][j]);
				}
				sb.append("\n");
			}
			System.out.print("#"+t+"\n"+sb);
		}
	}

	private static int[][] Rotation(int[][] arr) {
		int[][] result = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				result[i][j] = arr[N-j-1][i];
			}
		}
		return result;
	}
}
