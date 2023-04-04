import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int S = Integer.parseInt(br.readLine());
		
		char[] arr = br.readLine().toCharArray();
//		String[] arr = br.readLine().split("");

		int result = 0;
		int count = 0;
		for(int i = 1; i < S-1; i++) {
			if(arr[i-1]=='I' && arr[i]=='O' && arr[i+1]=='I') {
				count++;
				
				if(count==N) {
					result++;
					count--;
				}
				
				i++;
			} else {
				count=0;
			}
		}
		
		System.out.println(result);
	}
}
