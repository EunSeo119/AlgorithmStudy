import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 풀이: 정렬, 우선순위 큐 사용
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int result = 0;

        int[] road = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(road);

        Queue<Integer> queue = new PriorityQueue<>();

        for(int i = 1; i < N; i++) {
            queue.offer(road[i] - road[i-1]);
        }

        for(int i = 0; i < N-K; i++) {
            result += queue.poll();
        }

        System.out.println(result);
    }
}
