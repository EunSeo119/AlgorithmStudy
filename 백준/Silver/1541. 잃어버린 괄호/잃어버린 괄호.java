import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sub = new StringTokenizer(br.readLine(), "-");
		
		int result = Integer.MAX_VALUE;
		while(sub.hasMoreTokens()) {
			StringTokenizer add = new StringTokenizer(sub.nextToken(), "+");
			
			int sum = 0;
			while(add.hasMoreElements()) {
				sum+=Integer.parseInt(add.nextToken());
			}
			
			if(result==Integer.MAX_VALUE) {
				result=sum;
			} else {
				result-=sum;
			}
		}
		
		System.out.println(result);
	}
}
