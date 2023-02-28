import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Integer> dq = new ArrayDeque<>();
		
		int N = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch(command){
			case "push_front" : 
				dq.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back" :
				dq.addLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front" :
				if(dq.isEmpty()) {
					System.out.println(-1);
					break;
				}
				System.out.println(dq.pollFirst());
				break;
			case "pop_back" :
				if(dq.isEmpty()) {
					System.out.println(-1);
					break;
				}
				System.out.println(dq.pollLast());
				break;
			case "size" :
				System.out.println(dq.size());
				break;
			case "empty" :
				if(dq.isEmpty()) {
					System.out.println(1);
					break;
				} else {
					System.out.println(0);
					break;
				}
			case "front" :
				if(dq.isEmpty()) {
					System.out.println(-1);
					break;
				}
				System.out.println(dq.peekFirst());
				break;
			case "back" :
				if(dq.isEmpty()) {
					System.out.println(-1);
					break;
				}
				System.out.println(dq.peekLast());
				break;				
			}
		}
	}
}
