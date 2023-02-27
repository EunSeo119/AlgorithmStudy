import java.util.Scanner;

public class Solution {
	static int N;
	static int[] p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			System.out.print("#"+t+" ");
			N = sc.nextInt();
			p = new int[N+1];
			int m = sc.nextInt();
			
			makeSet();
			for(int i = 0; i < m; i++) {
				int check = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				if(check==0) {
					unoin(a, b);
				} else {
					System.out.print(check(a, b));
				}
			}
			System.out.println();
		}
	}
	
	private static int check(int a, int b) {
		// a의 집합의 대표 찾기
		int aRoot = find(a);
		// b의 집합의 대표 찾기
		int bRoot = find(b);
		if(aRoot == bRoot) return 1;
		
		return 0;	
	}

	private static void unoin(int a, int b) {
		// a의 집합의 대표 찾기
		int aRoot = find(a);
		// b의 집합의 대표 찾기
		int bRoot = find(b);
		if(aRoot == bRoot) return;
		
		p[bRoot] = aRoot;
		return;	
	}

	private static int find(int a) {
		if(p[a] == a) return a;
		return p[a] = find(p[a]);
	}

	private static void makeSet() {
		for(int i = 1; i <= N; i++) {
			p[i] = i;
		}
	}
}
