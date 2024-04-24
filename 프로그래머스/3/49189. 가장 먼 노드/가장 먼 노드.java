import java.util.*;
class Solution {
    static boolean[] visited;
    static List<Integer>[] graph;
    static int[] result;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        visited = new boolean[n+1];
        graph = new List[n+1];
        result = new int[n+1];
        
        for(int i = 0; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // for(int i = 0; i < edge.length; i++) {
        //     int[] node = edge[i];
        //     graph[node[0]][node[1]] = 1;
        //     graph[node[1]][node[0]] = 1;
        // }
        
        // 2차원 배열로 하면 메모리 초과가 나서 list로 수정함
        for(int i = 0; i < edge.length; i++){
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }
        
        bfs();
        
        Arrays.sort(result);
        int check = result[n];
        for(int i = n; i >= 0; i--) {
            if(result[i] != check) break;
            answer++;
        }
        return answer;
    }
    
    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.length+1];
        
        queue.offer(new int[] {1, 0});
        visited[1] = true;
        
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int num = node[0];
            int cnt = node[1];
            
            for(Integer nextNode : graph[num]) {
                if(visited[nextNode]) continue;
                
                result[nextNode] = Math.max(result[nextNode], cnt+1);
                queue.offer(new int[] {nextNode, cnt+1});
                visited[nextNode] = true;
            }
        }
    }
}