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
		
		int N = Integer.parseInt(br.readLine());
		
		Coor[] coorArr = new Coor[N];
		for(int i = 0; i < N; i++) {
			coorArr[i] = new Coor();
			StringTokenizer st = new StringTokenizer(br.readLine());
			coorArr[i].x = Integer.parseInt(st.nextToken());
			coorArr[i].y = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(coorArr, (o1, o2)->{
			if(o1.x==o2.x) {
				return o1.y-o2.y;
			}
			return o1.x-o2.x;
		});
		
		for(int i = 0; i < N; i++) {
			sb.append(coorArr[i].x+" "+coorArr[i].y+"\n");
		}
		System.out.println(sb);
	}
}
