import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int res[][] = new int[N][N];
			int tmp = 1;
			int x = 0;
			int y = 0;
			int dir = 0;
			int dx[] = {0, 1, 0, -1};
			int dy[] = {1, 0, -1, 0};
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					res[x][y] = tmp;
					int nx = x + dx[dir];
					int ny = y + dy[dir];
					if (nx < 0 || nx >= N || ny < 0 || ny >= N || res[nx][ny] != 0) {
						dir = (dir + 1) % 4;
					}
					x += dx[dir];
					y += dy[dir];
					tmp++;
				}
			}
			bw.write("#"+t+"\n");
			for (int j = 0; j< N; j++) {
				for (int k = 0; k<N; k++) {
					bw.write(res[j][k] + " ");
				}
				bw.write("\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
}
