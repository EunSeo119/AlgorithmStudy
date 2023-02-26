import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		
		int[] result = new int[K];
		int end = 0;
		for(int k = 0; k < K; k++) {
			int num = sc.nextInt();
			if(num==0) {
				end--;
			} else {
				result[end] = num;
				end++;
			}
		}
		
		int sum = 0;
		for(int i = 0; i < end; i++) {
			sum+=result[i];
		}
		System.out.println(sum);
	}
}
