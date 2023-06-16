import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());
		long sum = 0;
		int count = 0;
		
		for(int i = 1; ; i++) {
			if(sum > S) break;
			
			sum+=i;
			count++;
		}
		
		System.out.println(count-1);
		
	}
}