import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int N = 9;
	static int M = 7;
	static int[] inputs, numbers;
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		inputs = new int[N];
		numbers = new int[M];
		for(int i = 0; i < N; i++) {
//			inputs[i] = sc.nextInt();
			inputs[i] = Integer.parseInt(br.readLine());
		}
		
		comb(0, 0);
		
		bw.flush();
		bw.close();
	}
	private static void comb(int cnt, int start) throws IOException {
		if(cnt == M) {
			int sum = 0;
			for(int i = 0; i < M; i++) {
				sum+=numbers[i];
			}
			if(sum==100) {
				for(int j = 0; j < M; j++) {
//					System.out.println(numbers[j]);
					bw.write(numbers[j]+"\n");
				}
			}
			return;
		}
		
		for(int i = start; i < N; i++) {
			numbers[cnt] = inputs[i];
			comb(cnt+1, i+1);
		}
	}
}
