import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean[] broken = new boolean[10];
		
		for(int i = 0; i < M; i++) {
			broken[sc.nextInt()] = true;
		}
		
		int minClick = Math.abs(N-100);
		for(int i = 0; i <= 999999; i++) {
			String str = Integer.toString(i);
			int len = str.length();
			
			boolean isBreak = false;
			for(int j = 0; j < len; j++) {
				if(broken[str.charAt(j)-'0']==true) {
					isBreak = true;
					break;
				}
			}
			
			if(isBreak==false) {
				int nowClick = Math.abs(N-i) + len;
				minClick = Math.min(nowClick, minClick);
			}
		}
		
		System.out.println(minClick);
	}
}
