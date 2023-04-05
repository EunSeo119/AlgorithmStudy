import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 벨트에 놓인 접시의 수
		int d = sc.nextInt();	// 초밥의 가짓 수
		int k = sc.nextInt();	// 연속해서 먹는 접시의 수
		int c = sc.nextInt();	// 쿠폰 번호
		int result = 0;
		
		int[] belt = new int[N+k-1];
		for(int i = 0; i < N; i++) {
			belt[i] = sc.nextInt();
		}
		for(int i = 0; i < k-1; i++) {
			belt[N+i] = belt[i];
		}
		
		Queue<Integer> q = new LinkedList<>();
		int[] sushi = new int[d+1];
		
		for(int i = 0; i < k; i++) {
			q.offer(belt[i]);
			if(sushi[belt[i]]==0) {
				result++;
			}
			sushi[belt[i]]++;
		}
		
		if(sushi[c]==0) {
			result++;
		}
		sushi[c]++;
		
		int max = result;
		
		for(int i = k; i < N+k-1; i++) {
			int outSushi = q.poll();
			int inSushi = belt[i];
			q.offer(inSushi);
			if(sushi[inSushi]==0) {
				result++;
			}
			sushi[inSushi]++;
			if(sushi[outSushi]==1) {
				result--;
			}
			sushi[outSushi]--;
			max = Math.max(max, result);
		}
		
		System.out.println(max);
	}
}
