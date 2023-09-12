import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static int[][] graph;
    public int solution(int n, int[][] wires) {
        graph = new int[n+1][n+1];
        int answer = n;

        for(int i = 0; i < wires.length; i++) {
            int from = wires[i][0];
            int to = wires[i][1];
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        for(int i = 0; i < wires.length; i++) {
            int from = wires[i][0];
            int to = wires[i][1];

            // 선하나 끊기
            graph[from][to] = 0;
            graph[to][from] = 0;
            answer = Math.min(bfs(n, from), answer);

            // 선 복구하기
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        return answer;
    }

    public int bfs(int n, int start) {
        int[] visited = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        int count = 1;

        queue.offer(start);

        while (!queue.isEmpty()) {
            int check = queue.poll();
            visited[check] = 1;

            for(int i = 1; i <= n; i++) {
                if(visited[i] == 1) continue;

                if(graph[check][i] == 1) {
                    queue.offer(i);
                    count++;
                }
            }
        }

        return Math.abs(n-2*count); // (n-count) - count
    }
}
