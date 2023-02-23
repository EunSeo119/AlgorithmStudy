import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Coor{
	int x;
	int y;
	public Coor(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int[][] map;
	static Coor[] cArr;
	static int w, h;
	static int count;
	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			count = 0;
			
			if(w == 0 && h == 0) 
				break;
			
			map = new int[h][w];
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(map[i][j]==1) {
						bfs(i, j); 
					}
				}
			}
			System.out.println(count);
		}
	}

	private static void bfs(int x, int y) {
		Queue<Coor> queue = new ArrayDeque<>();

        queue.offer(new Coor(x, y));
        map[x][y] = 0;
        
        while (!queue.isEmpty()) {
            Coor current = queue.poll();
            
            for (int dir = 0; dir < 8; dir++) {
				int nx = dx[dir] + current.x;
				int ny = dy[dir] + current.y;
				
				if(ny < 0 || ny >= w || nx < 0 || nx >= h) continue;
				if(map[nx][ny] == 0) continue;

				queue.offer(new Coor(nx, ny));
				map[nx][ny] = 0;
			}
        }
        count++;
	}
}
