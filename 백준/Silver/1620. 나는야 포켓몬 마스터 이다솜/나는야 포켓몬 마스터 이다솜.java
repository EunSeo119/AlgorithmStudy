import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		HashMap<Integer, String> numMap = new HashMap<>();
		HashMap<String, Integer> nameMap = new HashMap<>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= N; i++) {
			String name = br.readLine();
			numMap.put(i, name);
			nameMap.put(name, i);
		}
		
		for(int i = 0; i < M; i++) {
			String quiz = br.readLine();
			char check = quiz.charAt(0);
			if(Character.isDigit(check)) {
				int num = Integer.parseInt(quiz);
				System.out.println(numMap.get(num));
			} else {
				System.out.println(nameMap.get(quiz));
			}
		}
	}
}
