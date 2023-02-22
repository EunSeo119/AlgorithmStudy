import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		String result = "<";
		
		for(int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		int count = 0;
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			count++;
			if(count%K==0) {
				result+=(temp+", ");
				continue;
			}
			queue.offer(temp);
		}
		
		System.out.println(result.substring(0, result.length()-2)+">");
	}
}
