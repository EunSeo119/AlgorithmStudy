import java.io.*;
import java.util.*;

/**
 * 풀이: bfs 활용
 */
public class Main {
    static class Info {
        int num;
        String str;

        Info(int num, String str) {
            this.num = num;
            this.str = str;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Queue<Info> queue = new LinkedList<>();
            boolean[] visited = new boolean[10000];

            queue.offer(new Info(A, ""));
            while(!queue.isEmpty()) {
                Info current = queue.poll();

                if(visited[current.num]) continue;

                if(current.num == B) {
                    System.out.println(current.str);
                    break;
                }

                visited[current.num] = true;

                int next = current.num * 2 % 10000;
                queue.offer(new Info(next, current.str + "D"));

                next = current.num - 1;
                if(next == -1) {
                    next = 9999;
                }
                queue.offer(new Info(next, current.str + "S"));

                next = (current.num % 1000) * 10 + current.num / 1000;;
                queue.offer(new Info(next, current.str + "L"));

                next = (current.num % 10) * 1000 + current.num / 10;
                queue.offer(new Info(next, current.str + "R"));
                
            }
        }
    }
}
