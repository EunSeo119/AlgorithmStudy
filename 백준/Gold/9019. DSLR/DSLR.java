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

                for(int i = 0; i < 4; i++) {
                    int next = 0;
                    String input = "";
                    if(i == 0) {
                        next = current.num * 2 % 10000;
                        input = "D";
                    } else if(i == 1) {
                        next = current.num - 1;
                        if(next == -1) {
                            next = 9999;
                        }
                        input = "S";
                    } else if(i == 2) {
                        next = (current.num % 1000) * 10 + current.num / 1000;;
                        input = "L";
                    } else {
                        next = (current.num % 10) * 1000 + current.num / 10;
                        input = "R";
                    }

                    queue.offer(new Info(next, current.str + input));
                }
            }
        }
    }
}
