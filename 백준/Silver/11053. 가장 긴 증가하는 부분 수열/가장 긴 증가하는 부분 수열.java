import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        dp[0] = 1;

        int max = 1;
        for(int i = 1; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(arr[j] >= arr[i]) continue;

                if(dp[j] >= dp[i]) {
                    dp[i] = dp[j]+1;
                    max = Math.max(max, dp[i]);
                }
            }
        }

        System.out.println(max);
    }
}
