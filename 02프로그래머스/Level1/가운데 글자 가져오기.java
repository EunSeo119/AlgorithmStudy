class Solution {
    public static String solution(String s) {
    	int num = (int)(s.length()/2);
    	String result = "";
    	
    	if (s.length()%2==0) {
    		result = s.substring(num-1,num+1);
    	}
    	else {
    		result+=s.charAt(num);
    	}
        return result;
    }
    
    // 테스트 코드
    public static void main(String[] args) {
		System.out.println(solution("abcde"));
		System.out.println(solution("qwer"));
	}
}
