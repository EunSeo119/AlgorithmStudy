import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Coor{
	int x;
	int y;
}

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Coor[] cArr = new Coor[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			Coor c = new Coor();
			c.x = Integer.parseInt(st.nextToken());
			c.y = Integer.parseInt(st.nextToken());
			cArr[i] = c;
		}
		
		Arrays.sort(cArr, (o1, o2)->{
			if(o1.y==o2.y) {
				return o1.x - o2.x;
			}
			return o1.y-o2.y;
		});
		
		for(int i = 0; i < N; i++) {
			sb.append(cArr[i].x+" "+cArr[i].y+"\n");
		}
		System.out.println(sb);
	}
}
