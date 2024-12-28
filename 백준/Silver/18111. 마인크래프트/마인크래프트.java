import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
                min = Math.min(min, map[i][j]);
            }
        }

        int resultTime = Integer.MAX_VALUE;
        int resultLen = -1;
        for(int check = min; check <= max; check++) {
            int useBlock = 0;
            int removeBlock = 0;
            int work = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(map[i][j] > check) {
                        work += (map[i][j] - check) * 2;
                        removeBlock += map[i][j] - check;
                    } else if(map[i][j] < check) {
                        work += check - map[i][j];
                        useBlock += check - map[i][j];
                    }
                }
            }

            if(useBlock <= (B + removeBlock)) {
                if(work < resultTime || (work == resultTime && check > resultLen)) {
                    resultTime = work;
                    resultLen = check;
                }
            }
        }

        System.out.println(resultTime + " " + resultLen);
    }
}
