import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int t = 1; t <= 10; t++) {
            int[][] ladder = new int[100][102];
            br.readLine();

            for(int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j <= 100; j++) {
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int x = 0;
            for(int i = 1; i <= 100; i++) {
                if(ladder[99][i] == 2) {
                    x = i;
                }
            }

            for(int y = 99; y >= 0; y--) {
                if(ladder[y][x-1] == 1) {
                    while(true) {
                        x--;
                        if(ladder[y-1][x] == 1) break;
                    }
                }
                else if(ladder[y][x+1] == 1) {
                    while(true) {
                        x++;
                        if(ladder[y-1][x] == 1) break;
                    }
                }
            }

            System.out.println("#" + t + " " + --x);
        }
    }
}
