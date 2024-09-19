import java.io.*;
import java.util.*;

/**
 * 풀이: bfs 사용
 */
public class Main {
    static boolean[][] visited;
    static char[][] picture1, picture2;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        picture1 = new char[N][N];
        picture2 = new char[N][N];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                picture1[i][j] = str.charAt(j);

                if(picture1[i][j] == 'G') {
                    picture2[i][j] = 'R';
                    continue;
                }

                picture2[i][j] = picture1[i][j];
            }
        }

        int result = 0;
        for(int t = 0; t < 2; t++) {
            visited = new boolean[N][N];
            result = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(visited[i][j]) continue;

                    visited[i][j] = true;
                    if(t == 0) {    // 일반인
                        bfs(new int[] {i, j}, picture1);
                    } else {    // 적록색약
                        bfs(new int[] {i, j}, picture2);
                    }

                    result++;
                }
            }
            System.out.print(result + " ");
        }
    }

    static private void bfs(int[] input, char[][] picture) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(input);

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;

                if(picture[current[0]][current[1]] == picture[nx][ny]) {
                    queue.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }

        }
    }
}
