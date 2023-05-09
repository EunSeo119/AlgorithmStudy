import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int N, M, map[][], num0, minTime;
	static ArrayList<Virus> virusList;
	static Virus[] activeVirus;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static class Virus{
		int r, c, time ;
		public Virus(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		virusList = new ArrayList<>();
		activeVirus = new Virus[M];
		map = new int[N][N];
		num0 = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) num0++;
				else if(map[i][j] == 2) virusList.add(new Virus(i, j, 0));
			}
		}
		
		minTime = Integer.MAX_VALUE;
		comb(0, 0);
		if(minTime != Integer.MAX_VALUE) System.out.println(minTime);
		else System.out.println(-1);
	}
	
	private static void comb(int cnt, int start) {
		if(cnt == M) {
			int[][] copyMap = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					copyMap[i][j] = map[i][j];
				}
			}
			int time =  bfs(copyMap);
			if(time != -1) minTime = Math.min(minTime, time);
			return;
		}
		
		for(int i = start; i < virusList.size(); i++) {
			activeVirus[cnt] = virusList.get(i);
			comb(cnt + 1, i + 1);
		}
	}
    
	private static int bfs(int[][] copyMap) {
		int tempNum0 = num0;
		int completeTime = 0;
		boolean visited[][] = new boolean[N][N];
		Queue<Virus> q = new ArrayDeque<>();
		
		for(int i = 0; i < activeVirus.length; i++) {
			q.offer(activeVirus[i]);	
			visited[activeVirus[i].r][activeVirus[i].c] = true;
		}
		
		while(!q.isEmpty() && tempNum0 != 0) {
			Virus virus = q.poll();
			for(int d = 0; d < 4; d++) {
				int nr = virus.r + dr[d];
				int nc = virus.c + dc[d];
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && copyMap[nr][nc] != 1) {
					if(copyMap[nr][nc] == 0) tempNum0--;
					q.offer(new Virus(nr, nc, virus.time + 1));
					visited[nr][nc] = true;
					copyMap[nr][nc] = 2;					
					completeTime = virus.time + 1;
 				}
			}
		}
		if(tempNum0 == 0) {
			return completeTime;
		}
		else {
			return -1;
		}
	}
}
