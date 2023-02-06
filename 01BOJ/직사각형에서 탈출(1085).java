import java.util.Scanner;

public class Main {
	public static void main2(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();

    // 1번째
//		int x_min = x;
//		int y_min = y;
//		if(w-x<x) {
//			x_min = w-x;
//		}
//		if(h-y<y) {
//			y_min = h-y;
//		}

    // 2번째
//		int x_min = Math.min(w-x, x);
//		int y_min = Math.min(h-y, y);
//		
//		System.out.println(Math.min(x_min, y_min));

    // 최종
		System.out.println(Math.min(Math.min(w - x, h - y), Math.min(x, y)));
	}
}
