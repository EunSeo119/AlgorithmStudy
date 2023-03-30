import java.util.Scanner;

public class Main {
	static int N;
	static int[][] W;
	static boolean[] visited;
	static int[] number;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		W = new int[N][N];
		visited = new boolean[N];
		number = new int[N+1];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				W[i][j]=sc.nextInt();
			}
		}
		
		perm(0);
		System.out.println(min);
	}

	private static void perm(int cnt) {
		if(cnt==N) {
			int sum = 0;
			number[N] = number[0];
			for(int i = 0; i < N; i++) {
				int start = number[i];
				int end = number[i+1];
				if(W[start][end]==0) {
					sum = Integer.MAX_VALUE;
					break;
				}
				sum += W[start][end];
			}
			
			min = min>sum?sum:min;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(visited[i])
				continue;
			
			visited[i] = true;
			number[cnt] = i;
			perm(cnt+1);
			visited[i] = false;
		}
	}
}