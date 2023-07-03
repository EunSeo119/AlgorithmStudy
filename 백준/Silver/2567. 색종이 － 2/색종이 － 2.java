import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[][] white = new int[101][101];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int j = x; j < x+10; j++) {
				for(int k = y; k < y+10; k++) {
					white[j][k] = 1;
				}
			}
		}
		
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int result = 0;
		
		for(int i = 1; i <= 100; i++) {
			for(int j = 1; j <= 100; j++) {
				if(white[i][j]==1) {
					for(int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if(white[nx][ny]==0) {
							result++;
						}
					}
				}
			}
		}
		
		System.out.println(result);
	}
}
