class Solution {
    public static int solution(int n) {
    	int result = 0;
    	for(int i = 1; i <= n/2; i++) {
    		if(n%i==0) {
    			result+=i;
    		}
    	}
        return result+n;
    }
    
    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        Solution c = new Solution();
        System.out.println(c.solution(12));
    }
}
