import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] memo = new long[N+1];

//        System.out.println(fibo1(N-1));
//        System.out.println(fibo2(N, memo));
        System.out.println(fibo3(N));
    }

    private static long fibo1(int N) {
        if(N < 2) {
            return N;
        }

        return fibo1(N-1) + fibo1(N-2);
    }

    private static long fibo2(int N, long[] memo) {
        if(memo[N] != 0) {
            return memo[N];
        }

        if(N < 2) {
            return N;
        }

        return memo[N] = fibo2(N-1, memo) + fibo2(N-2, memo);
    }

    private static long fibo3(int N) {
        long[] dp = new long[N+1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[N];
    }
}
