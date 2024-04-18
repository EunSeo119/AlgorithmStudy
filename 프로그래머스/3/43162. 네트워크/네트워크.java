import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            
            queue.offer(computers[i]);
            visited[i] = true;
            
            while(!queue.isEmpty()) {
                int[] computer = queue.poll();
                
                for(int j = 0; j < n; j++) {
                    if(visited[j] || computer[j] == 0) continue;

                    queue.offer(computers[j]);
                    visited[j] = true;
                }
            }
            
            answer++;
        }
        
        return answer;
    }
}