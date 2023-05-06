import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
        	Map<String, Integer> map = new HashMap<>();
        	
        	int N = sc.nextInt();
        	for(int i = 0; i < N; i++) {
        		String value = sc.next();
        		String key = sc.next();
        		if(map.containsKey(key)) {
        			map.put(key, map.get(key)+1);
        		} else {
        			map.put(key, 1);
        		}
        	}
        	
        	int result = 1;
        	for(int v : map.values()) {
        		result *= (v+1);
        	}
        	
        	System.out.println(result -1);
        }
    }
}