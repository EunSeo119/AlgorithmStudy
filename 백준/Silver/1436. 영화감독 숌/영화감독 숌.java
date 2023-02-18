import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int count = 0;
		int num = 666;
		while(count!=N) {
			if(String.valueOf(num).contains("666")) {
				count++;
			}
			num++;
		}
		System.out.println(num-1);
	}
}
