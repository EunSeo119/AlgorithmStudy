import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] answer;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		answer = new int[2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cut(0, 0, N);
		System.out.println(answer[0]);
		System.out.println(answer[1]);
	}

	private static void cut(int start, int end, int size) {
		int sum = 0;
		for (int i = start; i < start + size; i++) {
			for (int j = end; j < end + size; j++) {
				sum += map[i][j];
			}
		}
		if (sum == 0) {
			answer[0]++;
			return;
		} else if (sum == size * size) {
			answer[1]++;
			return;
		}
		int half = size / 2;
		cut(start, end, half);
		cut(start + half, end, half);
		cut(start, end + half, half);
		cut(start + half, end + half, half);

	}
}
