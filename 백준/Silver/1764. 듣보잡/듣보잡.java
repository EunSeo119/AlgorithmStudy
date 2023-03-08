import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		HashSet<String> noListen = new HashSet<>();
//		List<String> noListen = new ArrayList<>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			noListen.add(br.readLine());
		}
		
		int count = 0;
		List<String> noPerson = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			String noWatch = br.readLine();
			if(noListen.contains(noWatch)) {
				noPerson.add(noWatch);
				count++;
			}
		}
		
		Collections.sort(noPerson);
		System.out.println(count);
		for(String p : noPerson) {
			System.out.println(p);
		}
	}
}
