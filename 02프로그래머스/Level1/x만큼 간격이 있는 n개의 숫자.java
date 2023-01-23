import java.util.Arrays;

class Solution {
    public static long[] solution(long x, int n) {
        long[] answer = new long[n];
        
        for (int i = 1; i <= n; i++) {
        	answer[i-1]=x*i;
        }
        
        return answer;
    }
    
    // 테스트 코드
    public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(2,5)));
		System.out.println(Arrays.toString(solution(-4, 2)));
	}
}
