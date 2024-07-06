import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (Integer o1, Integer o2) -> {
                    if(Math.abs(o1) == Math.abs(o2)) {
                        return o1 - o2;
                    }
                    return Math.abs(o1) - Math.abs(o2);
                }
        );

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num == 0 && pq.isEmpty()) {
                System.out.println(0);
                continue;
            }

            if(num == 0) {
                System.out.println(pq.poll());
                continue;
            }

            pq.offer(num);
        }
    }
}
