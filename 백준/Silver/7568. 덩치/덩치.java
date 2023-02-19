import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		int[] rank = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		for(int i = 0; i < N; i++) {
			rank[i] = 1;
			for(int j = 0; j < N; j++) {
				if(i==j) continue;
				
				if(arr[i][0]<arr[j][0] && arr[i][1]<arr[j][1]) {
					rank[i]++;
				}
			}
			System.out.print(rank[i]+" ");
		}
	}
}
