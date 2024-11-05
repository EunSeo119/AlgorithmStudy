import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[] {0, 0, 0});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int depth = current[2]+1;
            
            for(int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                
                if(nx < 0 || ny < 0 || 
                   nx >= maps.length || ny >= maps[0].length || 
                   visited[nx][ny] || maps[nx][ny] == 0) continue;
                
                if(nx == maps.length-1 && ny == maps[0].length-1) {
                    return depth+1;
                }
                
                queue.offer(new int[] {nx, ny, depth});
                visited[nx][ny] = true;
            }
        }
        return -1;
    }
}