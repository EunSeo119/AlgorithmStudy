package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int N, M;
	static int[] inputs, numbers;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
//		N = sc.nextInt();
//		M = sc.nextInt();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		inputs = new int[N];
		numbers = new int[M];
		
		for(int i = 0; i < N; i++) {
			inputs[i]=i+1;
		}
		
		comb(0);
		
		bw.flush();
		bw.close();
	}
	
	private static void comb(int cnt) throws IOException {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
//				System.out.print(numbers[i]+" ");
				bw.write(numbers[i]+" ");
			}
//			System.out.println();
			bw.write("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			numbers[cnt] = inputs[i];
			comb(cnt+1);
		}
	}
}


public class Main {
	static int N, M;
	static int[] numbers, inputs;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		numbers = new int[M];
		inputs = new int[N];
		
		for (int i = 0; i < N; i++) inputs[i] = i+1;
		
		perm(0);
		System.out.println(sb.toString());
	}
	
	private static void perm(int cnt) {
		if(cnt == M) {
			for(int n: numbers) {
				sb.append(n+" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			numbers[cnt] = inputs[i];
			perm(cnt + 1);
		}
	}
}
