import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			int[][] graph = new int[N+1][N+1];
			int result = 0;
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				graph[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			
			Queue<Integer> q = new LinkedList<>();
			for(int i = 1; i <= N; i++) {
				int count = 0;
				boolean[] visited = new boolean[N+1];
				q.offer(i);
				visited[i] = true;
				
				while(!q.isEmpty()) {
					int current = q.poll();
					
					for(int j = 1; j <= N; j++) {
						if(graph[current][j]==1 && !visited[j]) {
							count++;
							q.offer(j);
							visited[j] = true;
						}
					}
				}
				
				boolean[] visited2 = new boolean[N+1];
				q.offer(i);
				visited2[i] = true;
				
				while(!q.isEmpty()) {
					int current = q.poll();
					
					for(int j = 1; j <= N; j++) {
						if(graph[j][current]==1 && !visited2[j]) {
							count++;
							q.offer(j);
							visited2[j] = true;
						}
					}
				}
				
				if(count==N-1) {
					result++;
				}
			}
			
			System.out.println("#"+t+" "+result);
		}
	}
}
