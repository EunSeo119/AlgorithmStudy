import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int N, R;
	static int[] numbers, young, gyu;
	static int win, lose;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int[] temp = new int[18];
			for (int i = 0; i < 9; i++) {
				int tmp = sc.nextInt();
				temp[tmp - 1] = tmp;
			}

			gyu = new int[9];
			young = new int[9];
			int gCount = 0;
			int yCount = 0;
			for (int i = 0; i < 18; i++) {
				if (temp[i] == 0) {
					young[yCount++] = i + 1;
				} else {
					gyu[gCount++] = temp[i];
				}
			}

			N = 9;
			R = 9;

			numbers = new int[R];
			win = 0;
			lose = 0;

			permutation(0, 0);

			System.out.println("#" + t + " " + win + " " + lose + " ");

		}
	}

	private static void permutation(int cnt, int flag) {
		if (cnt == R) {
			int gSum = 0;
			int ySum = 0;
			for (int i = 0; i < N; i++) {
				if (numbers[i] > gyu[i]) {
					ySum += (numbers[i]+ gyu[i]);
				} else if(numbers[i] < gyu[i]){
					gSum += (numbers[i]+ gyu[i]);
				}
			}
			if (gSum > ySum) {
				win++;
			} else if (gSum < ySum) {
				lose++;
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((flag & (1 << i)) != 0)
				continue;
			numbers[cnt] = young[i];
			permutation(cnt + 1, flag | (1 << i));
		}
	}
}
