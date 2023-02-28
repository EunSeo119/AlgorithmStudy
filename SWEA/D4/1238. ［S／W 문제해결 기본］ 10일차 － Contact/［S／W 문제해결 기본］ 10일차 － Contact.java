import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[][] graph;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			int dataLen = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			graph= new int[101][101];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < dataLen/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph[from][to] = 1;
			}
			
			bfs(start);
			
			System.out.println("#" + t + " " + result);
		}
	}

	private static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[101];
        
        queue.offer(start);
        visited[start] =  true;
        
        int current = 0;
        while (!queue.isEmpty()) {
            
        	int check = 0;
            for(int i = 0; i < queue.size(); i++) {
            	current = queue.poll();
            	
            	for(int j = 1; j <= 100; j++) {
            		if(graph[current][j]  != 0 && !visited[j]) {
            			queue.offer(j);
            			visited[j] = true;
            			check = Math.max(check, j);
            		}
            	}
            	if(check!=0) {
            		result = check;            		
            	}
            }
        }
	}
}
