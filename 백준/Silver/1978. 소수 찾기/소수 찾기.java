import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = 0;
		
		boolean[] bool = new boolean[1001];  // 2이상 1000이하의 자연수 중에서 소수를 찾을거다.
		
		//에라토스테네스의 체. 소수면 false, 아니면 true
		bool[0] = true;
		bool[1] = true;
		for(int i = 2; Math.pow(i, 2) < 1000; i++) {
			if(bool[i] == false) {
				for(int j = 2; i * j <= 1000; j++ ) {
					bool[i*j] = true;
				}
			}
		}
		//소수면 카운트를 1 증가시킴
		for(int i = 0; i < N; i++) {
			if( bool[Integer.parseInt(st.nextToken())] == false ) ++cnt;
		}
		
		System.out.println(cnt);
	}
}