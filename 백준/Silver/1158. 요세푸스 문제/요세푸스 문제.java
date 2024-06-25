import java.io.*;
import java.util.*;

/**
 * Queue 사용
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        while(!queue.isEmpty()) {
            for(int i = 0; i < K-1; i++) {
                queue.offer(queue.poll());
            }
            result.add(queue.poll());
        }

        sb.append("<");
        for(int i = 0; i < N; i++) {
            sb.append(result.get(i)).append(", ");
        }

        System.out.println(sb.substring(0, sb.length()-2) + ">");
    }
}
