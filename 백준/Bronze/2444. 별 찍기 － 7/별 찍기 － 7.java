import java.util.Scanner;

class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i = 1; i<=T; i++) {
			for (int j = 0; j < T-i; j++) {
				System.out.print(" ");
			}
			for(int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			for(int k = i-1; k > 0; k--) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i = T-1; i> 0; i--) {
			for (int j = 0; j < T-i; j++) {
				System.out.print(" ");
			}
			for(int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			for(int k = i-1; k > 0; k--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}