import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int N = 0, L = 0;
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			int[][] data = new int[N][2];
			int result = 0;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				data[i][0] = Integer.parseInt(st.nextToken());
				data[i][1] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < (1<<N); i++) {
				int taste = 0;
				int kcal = 0;
				for(int j = 0; j < N; j++) {
					if((i & (1<<j))!=0) {
						taste += data[j][0];
						kcal += data[j][1];
					}
				}
				if(kcal <= L) {
					result = Math.max(result, taste);
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}
}
