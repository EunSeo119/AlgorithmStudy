import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N, H, W, result;
	static int[] numbers;
//	static boolean[] visited;
	static int[][] bricks, tmpBricks;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// 쏜 구슬 개수
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			bricks = new int[H][W];
			for(int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					bricks[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
//			inputs = new int[H];
			numbers = new int[N];
			result = Integer.MAX_VALUE;
//			visited = new boolean[H];
//			for(int i = 0; i < H; i++) inputs[i] = i;
			
			perm(0);
			
			System.out.println("#"+t+" "+result);
		}
	}
	
	private static void perm(int cnt) {
		if(cnt==N) {
			tmpBricks = new int[H][W];
			//Arrays.copyOf() = 1차원 카피 
			for(int i = 0; i <H; i++) {
				tmpBricks[i] = Arrays.copyOf(bricks[i], W);
			}
			
			// 중복 순열로 뽑힌 구슬 자리(numbers배열) 순서대로 벽돌깨기
			for(int n : numbers) {
				for(int i = 0; i < H; i++) {
					if(tmpBricks[i][n]!=0) {
						remove(i, n);
						break;
					}
				}
				// 벽돌 내리기
				for (int j = 0; j < W; j++) {
					int idx = H - 1;
					for (int i = H - 1; i >= 0; i--) {
						if (tmpBricks[i][j] != 0) {
							tmpBricks[idx][j] = tmpBricks[i][j];
							if (idx != i)
								tmpBricks[i][j] = 0;
							idx--;
						}
					}
				}
			}
			
			int count = 0;
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if(tmpBricks[i][j]!=0) {
						count++;
					}
				}
			}
			result = Math.min(result, count);
		
			return;
		}
		
		for(int i = 0; i < W; i++) {
//			if(visited[i]) continue;
			
//			visited[i] = true;
			numbers[cnt] = i;
			perm(cnt+1);
//			visited[i] = false;
		}
	}
	
	private static void remove(int x, int y) {
		int bombNum = tmpBricks[x][y];
		tmpBricks[x][y] = 0;
		for (int i = 1; i < bombNum; i++) {
			for(int d = 0; d < 4; d++) {
				int nx = x+dx[d]*i;
				int ny = y+dy[d]*i;
				if (nx >= 0 && nx < H && ny >= 0 && ny < W)
					remove(nx, ny);
				
			}

		}
	}
	
	private static void remove2(int x, int y) {
		int s = tmpBricks[x][y];
		tmpBricks[x][y] = 0;
		for (int i = 1; i < s; i++) {
			if (x + i < H)
				remove(x + i, y);
			if (x - i >= 0)
				remove(x - i, y);
			if (y + i < W)
				remove(x, y + i);
			if (y - i >= 0)
				remove(x, y - i);
			
		}
	}
}