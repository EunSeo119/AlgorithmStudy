import java.util.*;
import java.io.*;

/**
 * 풀이 : bfs 활용
 */
public class Main {
    static int[] check = {1, -1, 2};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] visited = new int[1000001];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(N);
        visited[N] = 1;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            if(current == K) break;

            for(int i = 0; i < 3; i++) {
                int next = (i == 2) ? current * 2 : current + check[i];

                if(next < 0 || next >= 1000001 || visited[next] != 0) continue;

                visited[next] = visited[current]+1;

                queue.offer(next);
            }
        }

        System.out.println(visited[K]-1);
    }
}
