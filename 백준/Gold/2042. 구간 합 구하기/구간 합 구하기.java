import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] num;
    static long[] tree;
	
    static void update(int index, long value) {
    	while(index < tree.length) {
    		tree[index] += value;
    		index += (index & -index);
    	}
    }
    
    static long sum(int index) {
    	long result = 0;
    	while (index > 0) {
    		result += tree[index];
    		index -= (index & -index);
    	}
    	return result;
    }
    
    static long getRange(int start, int end) {
    	return sum(end) - sum(start-1);
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		num = new long[N+1];
		tree = new long[N+1];
		
		for(int i = 1 ; i <= N; i++) {
			num[i] = Long.parseLong(br.readLine());
		}
		
		for (int i = 1; i <= N; i++) {
        	update(i, num[i]);
        }
		
		for(int i = 0; i < M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if(a==1) {
				update(b, c - num[b]);
				num[b] = c;
			}
			else if(a==2) {
				System.out.println(getRange(b, (int) c));
			}
		}
	}
}
