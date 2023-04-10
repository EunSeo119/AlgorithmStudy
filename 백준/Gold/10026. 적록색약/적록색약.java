import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int count1 = 0;
	static int count2 = 0;
	static int N;
	static String[][] grid;
	static boolean[][] visited;
	static class Pos {
		int x, y;
		String color;

		public Pos(int x, int y, String color) {
			super();
			this.x = x;
			this.y = y;
			this.color = color;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		grid = new String[N][N];
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for(int j = 0; j < N; j++) {
				grid[i][j] = str[j];
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					count1++;
					bfs1(i, j, grid[i][j]);
				}
			}
		}
		
		System.out.println(count1);
		
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					count2++;
					bfs2(i, j, grid[i][j]);
				}
			}
		}
		
		System.out.println(count2);
	}

	private static void bfs2(int x, int y, String color) {
		Queue<Pos> q = new LinkedList<>();
		
		q.offer(new Pos(x, y, color));
		visited[x][y] = true;

		while(!q.isEmpty()) {
			Pos current = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = dx[i] + current.x;
				int ny = dy[i] + current.y;
				if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
				if(!visited[nx][ny]) {
					if((grid[nx][ny].equals("R") || grid[nx][ny].equals("G")) && (current.color.equals("R") || current.color.equals("G"))) {
						q.offer(new Pos(nx, ny, "R"));
						visited[nx][ny] = true;						
					} else if((grid[nx][ny].equals("B")) && (current.color.equals("B"))){
						q.offer(new Pos(nx, ny, "B"));
						visited[nx][ny] = true;	
					}
				}
			}			
		}
	}

	private static void bfs1(int x, int y, String color) {
		Queue<Pos> q = new LinkedList<>();
		
		q.offer(new Pos(x, y, color));
		visited[x][y] = true;

		while(!q.isEmpty()) {
			Pos current = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = dx[i] + current.x;
				int ny = dy[i] + current.y;
				if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
				if(grid[nx][ny].equals(current.color) && !visited[nx][ny]) {
					q.offer(new Pos(nx, ny, current.color));
					visited[nx][ny] = true;
				}
			}			
		}
	}
}
