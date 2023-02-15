import static java.lang.Integer.getInteger;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] flys = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					flys[i][j] = sc.nextInt();
				}
			}
			int result = -1000000;
			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {
					int sum = 0;
					for (int k = 0; k < M; k++) {
						for (int l = 0; l < M; l++) {
							sum += flys[i + k][j + l];
						}
					}
					if (sum > result) {
						result = sum;
					}
				}
			}
			System.out.printf("#%d %d\n", t + 1, result);
		}
	}
}