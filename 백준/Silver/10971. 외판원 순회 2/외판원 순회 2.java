import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 풀이: dfs 사용(백트래킹)
 */
public class Main {
    static boolean[] visited;
    static int N, result;
    static int[][] city;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        city = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N];
        result = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(0, 0, i, i);
        }

        System.out.println(result);
    }

    private static void dfs(int depth, int sum, int start, int now) {
        if(depth == N-1) {
            if(city[now][start] != 0) {
                result = Math.min(result, sum+city[now][start]);
            }
            return;
        }

        for(int i = 0; i < N; i++) {
            if(visited[i] || city[now][i] == 0) continue;

            visited[i] = true;
            dfs(depth+1, sum+city[now][i], start, i);
            visited[i] = false;
        }

    }
}
