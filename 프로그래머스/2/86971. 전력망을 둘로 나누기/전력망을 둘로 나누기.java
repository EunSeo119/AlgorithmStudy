import java.util.*;

class Solution {
    // 2차원 배열과 bfs를 사용하여 품.
    // 만들어진 wire가 연결된 graph를 하나씩 끊었다가 다시 복구하면서 모든 경우의 수를 전부 탐색함(완전탐색)
    int[][] graph;
    public int solution(int n, int[][] wires) {
        int answer = n;
        graph = new int[n+1][n+1];

        for(int i = 0; i < wires.length; i++) {
            int from = wires[i][0];
            int to = wires[i][1];
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        for(int i = 0; i < wires.length; i++) {
            int from = wires[i][0];
            int to = wires[i][1];

            // 전선 끊기
            graph[from][to] = 0;
            graph[to][from] = 0;

            answer = Math.min(answer, bfs(from, n));

            // 전선 다시 복구
            graph[from][to] = 1;
            graph[to][from] = 1;
        }
        return answer;
    }

    // 끊어져있는 하나의 전력망 네트워크만 bfs로 구한뒤 둘의 차이를 수학으로 계산하여 리턴함.
    private int bfs(int start, int n) {
        int[] visited = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        int count = 1;

        queue.offer(start);

        while(!queue.isEmpty()) {
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
        
        // 원래 식 Math.abs((n-1)-(count-1)-count)
        return Math.abs(n-2*count);
    }
}