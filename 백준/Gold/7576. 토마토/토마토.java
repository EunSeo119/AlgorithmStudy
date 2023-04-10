import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());	// 세로
		int N = Integer.parseInt(st.nextToken());	// 가로
		List<Integer>[] box = new ArrayList[N];
		Queue<int[]> ripeTomato = new LinkedList<>();
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int day = 0;
		
		int checkZero = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			box[i] = new ArrayList<>();
			for(int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				box[i].add(temp);
				if(temp == 1) {
					ripeTomato.offer(new int[] {i, j, 0});
				} else if(temp == 0) {
					checkZero++;
				}
			}
		}
		
		if(checkZero==0) {
			System.out.println(0);
			return;
		}
		
		while(!ripeTomato.isEmpty()) {
			int[] current = ripeTomato.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = dx[i]+current[0];
				int ny = dy[i]+current[1];
				if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
				if(box[nx].get(ny)==0) {
					ripeTomato.offer(new int[] {nx, ny, current[2]+1});
					day = current[2]+1;
					box[nx].set(ny, 1);
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			if(box[i].contains(0)) {
				System.out.println(-1);
				return;
			}			
		}
		
		System.out.println(day);
	}
}
