import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			
			int[][] apart = new int[k+1][n];
			
			for(int i = 0; i < n; i++) {
				apart[0][i] = i+1;
			}
			
			for(int i = 1; i <= k; i++) {
				apart[i][0] = 1;
				for(int j = 1; j < n; j++) {
					apart[i][j] = apart[i][j-1]+apart[i-1][j];
				}
			}
			System.out.println(apart[k][n-1]);
		}
	}
}
