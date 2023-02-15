import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int sum = 0;
			for(int j = 0; j < 10; j++) {
				int num = sc.nextInt();
				sum+=num;
			}
			System.out.print("#"+(i+1)+" ");
			System.out.println(Math.round((double)sum/(double)10));
		}
	}
}