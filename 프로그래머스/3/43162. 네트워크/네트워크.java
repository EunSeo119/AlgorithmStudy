import java.util.*;
class Solution {
    static boolean[] visited;
    static int result;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        result = 0;
        bfs(n, computers);
        return result;
    }
    
    private static void bfs(int n, int[][] computers) {
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            
            Queue<Integer> q = new LinkedList<>();
            
            q.offer(i);
            visited[i] = true;
            
            while(!q.isEmpty()) {
                int current = q.poll();
                
                for(int j = 0; j < n; j++) {
                    if(computers[current][j] == 1 && !visited[j]) {
                        q.offer(j);
                        visited[j] = true;
                    }
                }
            }
            
            result++;
        }
        
    }
}