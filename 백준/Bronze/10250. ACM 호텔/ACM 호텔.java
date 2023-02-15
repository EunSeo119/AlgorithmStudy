import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
//		int T = sc.nextInt();
		int T = Integer.parseInt(st.nextToken());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int floor = 0;
			int ho = 1;
			
			for(int i = 1; i <= N; i++) {
				floor=i%H;
				if(floor==0) {
					floor=H;
				}
				if(floor==1 && i!=1) {
					ho++;
				}
			}
//			System.out.println(floor*100+ho);
			bw.write((floor*100+ho)+"\n");
			bw.flush();
		}
		bw.close();
	}
}