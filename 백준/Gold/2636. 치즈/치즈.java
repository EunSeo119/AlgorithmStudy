import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int r, c;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] cheese;
	static int cheeseCount;
	static int time = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		cheese = new int[r][c];
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
				if(cheese[i][j]==1) {
					cheeseCount++;
				}
			}
		}
		
		if(cheeseCount==0) {
			System.out.println(0);
			System.out.println(0);
			return;
		}
		
		while(true) {
			time++;
			int result = cheeseCount;
			cheeseCount=0;
			outCheese();
			meltCheese();
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					if(cheese[i][j]==-2 || cheese[i][j]==-1) {
						cheese[i][j]=0;
					}
					if(cheese[i][j]==1) {
						cheeseCount++;
					}
				}
			}
			if(cheeseCount==0) {
				System.out.println(time);
				System.out.println(result);
				return;
			}
			
		}
	}

	private static void meltCheese() {
		for(int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(cheese[i][j]==-1) {
					for(int k = 0; k < 4; k++) {
						int nx = dx[k] + i;
						int ny = dy[k] + j;
						if(nx<0 || ny<0 || nx>=r || ny>=c) continue;
						if(cheese[nx][ny]==1) {
							cheese[nx][ny] = -2; 	// 지울 치즈는 -2로 저장
						}
					}
				}
			}
		}
	}

	private static void outCheese() {
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[] {0,0});
		cheese[0][0] = -1;
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = dx[i] + current[0];
				int ny = dy[i] + current[1];
				if(nx<0 || ny<0 || nx>=r || ny>=c) continue;
				if(cheese[nx][ny]==0) {
					cheese[nx][ny] = -1;	// 바깥 공기 -1로 저장
					q.offer(new int[] {nx, ny});
				}
			}
		}
	}
}