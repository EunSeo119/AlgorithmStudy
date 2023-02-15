import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int s_num = sc.nextInt();
		int[] button = new int[s_num];
		for (int i = 0; i < s_num; i++) {
			button[i] = sc.nextInt();
		}
		int student = sc.nextInt();
		for (int i = 0; i < student; i++) {
			int gender = sc.nextInt();
			int num = sc.nextInt();

			if (gender == 1) {
				for (int j = 0; j < s_num; j++) {
					if ((j + 1) % num == 0) {
						button[j] = button[j] == 1 ? 0 : 1;
					}
				}
			} else if (gender == 2) {
				for (int j = 0; j < Math.min(num, s_num-num); j++) {
					if (num - j - 2 >= 0 && num + j < s_num && button[num - j - 2] == button[num + j]) {
						button[num - j - 2] = button[num - j - 2] == 1 ? 0 : 1;
						button[num + j] = button[num + j] == 1 ? 0 : 1;
					} else {
						break;
					}
				}
				button[num - 1] = button[num - 1] == 1 ? 0 : 1;
			}
		}
		for (int i = 1; i <= s_num; i++) {
			System.out.print(button[i-1] + " ");
			if (i % 20 == 0) {
				System.out.println();
			}
		}
	}
}