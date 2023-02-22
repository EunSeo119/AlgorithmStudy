import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, min;
	static int[] company, home, numbersX, numbersY;
	static int[][] customer;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			visited = new boolean[N];
			numbersX = new int[N];
			numbersY = new int[N];
			company = new int[2];
			st = new StringTokenizer(br.readLine());
			company[0] = Integer.parseInt(st.nextToken());
			company[1] = Integer.parseInt(st.nextToken());
			
			home = new int[2];
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			
			customer = new int[N][2];
			for(int i = 0; i < N; i++) {
				customer[i][0] = Integer.parseInt(st.nextToken());
				customer[i][1] = Integer.parseInt(st.nextToken());
			}
			
			min = Integer.MAX_VALUE;
			perm(0);
			System.out.println("#"+t+" "+min);
		}
	}
	private static void perm(int cnt) {
		if(cnt==N) {
			int x = Math.abs(company[0]-numbersX[0]);
			int y = Math.abs(company[1]-numbersY[0]);
			int distance = x+y;
			for(int i = 1; i < N; i++) {
				x = Math.abs(numbersX[i-1]-numbersX[i]);
				y = Math.abs(numbersY[i-1]-numbersY[i]);
				distance += (x+y);
			}
			distance += (Math.abs(numbersX[N-1]-home[0])+Math.abs(numbersY[N-1]-home[1]));
			min = min>distance? distance : min;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			numbersX[cnt] = customer[i][0];
			numbersY[cnt] = customer[i][1];
			perm(cnt+1);
			visited[i] = false;
		}
	}
}
