import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int temp = A*B;
		
		while(B != 0) {
			int R = A % B;
			
			A = B;
			B = R;
		}
		
		System.out.println(A);
		System.out.println(temp/A);
	}
}
