import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	static class Pos implements Comparable<Pos>{
		int x;
		int y;
		int weight;
		public Pos(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.weight = w;
		}
		@Override
		public int compareTo(Pos o) {
			return this.weight - o.weight;
		}
		
	}
	
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] resultMap;
	static int N;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			resultMap = new int[N][N];
			result = Integer.MAX_VALUE;
			for(int i=0; i<N; i++)
                Arrays.fill(resultMap[i], Integer.MAX_VALUE);
			resultMap[0][0] = 0;
            
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(),"");
				char[] arr = st.nextToken().toCharArray();
				for(int j = 0; j < N; j++) {
					map[i][j] = arr[j]-'0';
				}
			}
			
			bfs(0,0,0);
			
			System.out.println("#"+ t +" "+ result);
		}
	}
	private static void bfs(int x, int y, int weight) {
//		Queue<Pos> queue = new ArrayDeque<>();
		PriorityQueue<Pos> queue = new PriorityQueue<>();

        queue.offer(new Pos(x, y, weight));
//        map[x][y] = 0;

        while (!queue.isEmpty()) {
            Pos current = queue.poll();
            int cx = current.x;
            int cy = current.y;
            int cw = current.weight;
            
            if(cx==N-1 && cy==N-1) {
            	result = resultMap[cx][cy]>result? result : resultMap[cx][cy];
            }
            
            if(result <= cw) {
            	continue;
            }
            
            for (int dir = 0; dir < 4; dir++) {
				int nx = dx[dir] + cx;
				int ny = dy[dir] + cy;
				
				
				if(nx>=0 && nx < N && ny >=0 && ny < N  ) {
					int nw = resultMap[cx][cy] + map[nx][ny];
					if(resultMap[nx][ny] > nw) {
						resultMap[nx][ny] = nw;
						queue.offer(new Pos(nx, ny, nw));						
					}
				}
			}
        }
	}
}