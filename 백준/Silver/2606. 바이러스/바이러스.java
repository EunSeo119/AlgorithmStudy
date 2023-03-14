import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int count = 0;
	static boolean[] visited;
	static int nodeNum;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		nodeNum = sc.nextInt();
		int edgeNum = sc.nextInt();
		arr = new int[nodeNum+1][nodeNum+1];
		visited = new boolean[nodeNum+1];
		
		for(int i = 0; i < edgeNum; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		
		bfs(1);
		System.out.println(count);
	}

	private static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(n);
		visited[n]=true;
		
		while(!q.isEmpty()) {
			int num = q.poll();
			for(int i = 1; i <= nodeNum; i++) {
				if(!visited[i] && arr[num][i]==1) {
					q.offer(i);
					count++;
					visited[i]=true;
				}
			}
		}
	}
}
