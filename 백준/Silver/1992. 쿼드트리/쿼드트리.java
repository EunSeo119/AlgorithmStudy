import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
8
00000000
00000000
00001111
00001111
00011111
00111111
00111111
00111111
 */
public class Main {
	static int[][] spaces;
	
	static void cut(int r, int c, int size) {

		int sum = 0;
		for(int i = r, rEnd = r+size; i < rEnd; i++) {
			for(int j = c, cEnd = c+size; j < cEnd; j++) {
				sum += spaces[i][j];
			}
		}
		
		if(sum == size * size) {
			System.out.print(1);
			return;
		} else if(sum == 0) {
			System.out.print(0);
			return;
		} else {	// 혼합된 상황
			// 4분할
			int half = size/2;
			System.out.print("(");
			cut(r, c, half);
			cut(r, c+half, half);
			cut(r+half, c, half);
			cut(r+half, c+half, half);
			System.out.print(")");
		}
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		spaces = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				spaces[i][j] = str.charAt(j)-'0';
			}
		}
		
		cut(0,0,N);
	}
}
