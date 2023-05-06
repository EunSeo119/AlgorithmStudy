import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int blue, white;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		partition(0, 0, N);
		
		System.out.println(white);
		System.out.println(blue);
	}

	private static void partition(int x, int y, int size) {
		if(checkColor(x, y, size)) {
			if(map[x][y]==1) {
				blue++;
			} else {
				white++;
			}
			return;
		}
		
		int newSize = size/2;
		partition(x, y, newSize);
		partition(x+newSize, y, size/2);
		partition(x, y+newSize, size/2);
		partition(x+newSize, y+newSize, size/2);
	}

	private static boolean checkColor(int x, int y, int size) {
		int color = map[x][y];
		
		for(int i = x; i < x+size; i++) {
			for(int j = y; j < y+size; j++) {
				if(map[i][j]!=color) return false;
			}
		}
		
		return true;
	}
}
