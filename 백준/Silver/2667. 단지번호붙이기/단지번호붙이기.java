import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int N;
	static int[][] map;
	static int danziCount = 0;
	static boolean finish = false;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Queue<int[]> q = new LinkedList<>();
	static List<Integer> danzi;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		danzi = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			String[] input = br.readLine().split("");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		while(true) {
			findHouse();
			if(finish) break;
			findDanzi();
		}
		
		Collections.sort(danzi);
		System.out.println(danziCount);
		for(int i = 0; i < danziCount; i++) {
			System.out.println(danzi.get(i));
		}
		
	}

	private static void findDanzi() {
		int houseCount = 0;
		while(!q.isEmpty()) {
			int[] current = q.poll();
			houseCount++;
			
			for(int i = 0; i < 4; i++) {
				int nx = dx[i] + current[0];
				int ny = dy[i] + current[1];
				if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
				if(map[nx][ny]==1) {
					q.offer(new int[] {nx, ny});
					map[nx][ny]=0;
				}
			}
		}
		danzi.add(houseCount);
	}

	private static void findHouse() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j]==1) {
					q.offer(new int[] {i, j});
					map[i][j]=0;
					danziCount++;
					return;
				}
			}
		}
		finish = true;
		return;
	}
}
