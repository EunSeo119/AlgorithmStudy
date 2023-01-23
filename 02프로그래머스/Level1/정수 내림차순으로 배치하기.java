import java.util.Arrays;

class Solution {
    public static long solution(long n) {
    	String[] list = String.valueOf(n).split("");
    	Arrays.sort(list);
    	
    	StringBuffer sb = new StringBuffer();
    	for(String s : list) {
    		sb.append(s);
    	}
    	
    	return Long.valueOf(sb.reverse().toString());
    }
    
    // 테스트 코드
    public static void main(String[] args) {
		System.out.println(solution(118372));
	}
}
