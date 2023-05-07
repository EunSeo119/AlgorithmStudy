import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int N, M;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int result = 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j)-'0'; 
			}
		}
		
		bfs();
		System.out.println(result);
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0, 1});
		map[0][0] = 0;
		
		while(!q.isEmpty()) {
			int[] current = q.poll();

			for(int i = 0; i < 4; i++) {
				int nx = dx[i] + current[0];
				int ny = dy[i] + current[1];
				if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
				if(nx==N-1 && ny==M-1) {
					result = current[2]+1;
					return;
				}
				if(map[nx][ny]==1) {
					q.offer(new int[] {nx, ny, current[2]+1});
					map[nx][ny] = 0;
				}
			}
		}
	}
}
