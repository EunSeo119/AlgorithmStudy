import java.io.*;
import java.util.*;

public class Main {
    static int N, maxSum, answer = 0;
    static int[] numbers, result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        result = new int[3];
        maxSum = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        comb(0, 0);

        System.out.println(answer);
    }

    private static void comb(int start, int cnt) {
        if(cnt == 3) {
            int sum = 0;
            for(int i = 0; i < 3; i++) {
                sum += result[i];
            }

            if(sum <= maxSum) {
                answer = Math.max(sum, answer);
            }

            return;
        }

        for(int i = start; i < N; i++) {
            result[cnt] = numbers[i];
            comb(i+1, cnt+1);
        }
    }
}
