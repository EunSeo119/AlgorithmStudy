import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] farm = new int[N][N];

            for(int i = 0; i < N; i++) {
                String s = br.readLine();
                for(int j = 0; j < N; j++) {
                    farm[i][j] = s.charAt(j) - '0';
                }
            }

            int item = N/2;
            int w = 1;
            int sum = 0;
            for(int i = 0; i < N; i++) {
                for(int j = item; j < item+w; j++) {
                    sum += farm[i][j];
                }

                if(i < N/2) {
                    w+=2;
                    item--;
                } else {
                    w-=2;
                    item++;
                }
            }
            System.out.println("#" + t + " " + sum);
        }
    }
}
