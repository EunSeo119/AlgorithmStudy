import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int five = 0;
		int three = -1;
		int temp = 0;
		if(N%3==0) {
			three = N/3;
		}
		for(int i = N/5; i > 0; i--) {
			temp=N-(i*5);
			if(temp%3==0) {
				five = i;
				three = temp/3;
				break;
			}
		}
		if(three==-1) {
			System.out.println(-1);
		} else {
			System.out.println(five+three);
		}
	}
}
