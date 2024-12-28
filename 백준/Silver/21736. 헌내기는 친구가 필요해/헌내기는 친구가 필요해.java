import java.util.*;
import java.io.*;

/**
 * 풀이 : bfs 활용
 */
public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();
        char[][] map = new char[N][M];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);

                if(map[i][j] == 'I') {
                    queue.offer(new int[] {i, j});
                    map[i][j] = 'X';
                }
            }
        }

        int result = 0;
        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = dx[i] + current[0];
                int ny = dy[i] + current[1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 'X') continue;

                if(map[nx][ny] == 'P') {
                    result++;
                }

                map[nx][ny] = 'X';
                queue.offer(new int[] {nx, ny});
            }
        }

        if(result == 0) {
            System.out.println("TT");
        } else {
            System.out.println(result);
        }
    }
}
