import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int[][] visited = new int[maps.length][maps[0].length];
        Queue<int[]> queue = new LinkedList<>();
        
        visited[0][0] = 1;
        queue.offer(new int[] {0, 0});
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // maps 벗어나는 경우 체크
                if(nx < 0 || nx > maps.length-1 || ny < 0 || ny > maps[0].length-1) {
                    continue;
                }
                
                // 방문한 적이 없고 벽이 없는 자리일 시 queue에 추가
                if(visited[nx][ny] == 0 && maps[nx][ny] == 1) {
                    visited[nx][ny] = visited[x][y] + 1;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
        
        answer = visited[maps.length-1][maps[0].length-1];
        
        if(answer == 0) return -1;
        
        return answer;
    }
}