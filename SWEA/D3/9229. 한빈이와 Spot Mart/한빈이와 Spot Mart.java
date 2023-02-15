import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());

		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int[] snack = new int[N];
			for(int i = 0; i < N; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = -1;
			for(int i = 0; i < N-1; i++) {
				for(int j = i+1; j < N; j++) {
					if((snack[i]+snack[j])<=M) {
						max = Math.max(max, snack[i]+snack[j]);
					}
				}
			}
			System.out.println("#"+t+" "+max);
		}
	}
}
