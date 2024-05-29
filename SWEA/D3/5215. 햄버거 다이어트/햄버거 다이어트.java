import java.io.*;
import java.util.*;

public class Solution {
    static int[][] score;
    static int result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            score = new int[N][2];
            result = 0;

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                score[i][0] = Integer.parseInt(st.nextToken());
                score[i][1] = Integer.parseInt(st.nextToken());
            }

            subset(N, L);

            System.out.println("#" + t + " " + result);
        }
    }

    private static void subset(int N, int L) {
        for(int i = 0; i < (1<<N); i++) {
            int taste = 0;
            int kcal = 0;
            for(int j = 0; j < N; j++) {
                if((i & (1<<j)) == 0) continue;

                taste += score[j][0];
                kcal += score[j][1];
            }

            if(kcal <= L) {
                result = Math.max(taste, result);
            }
        }
    }
}
