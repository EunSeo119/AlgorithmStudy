import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int paper = sc.nextInt();
		int count = 0;
		int[][] board = new int[100][100];
		for(int t = 0; t < paper; t++) {
			int w = sc.nextInt();
			int l = sc.nextInt();
			
			for(int i = w-1; i < w+10-1; i++) {
				for(int j = l-1; j < l+10-1; j++) {
					if(board[i][j]==0) {
						board[i][j] = 1;	
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}
}
