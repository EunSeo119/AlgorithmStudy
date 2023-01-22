class Solution {
//    public static int solution(String s) {
//    	int result = 0;
//    	for (int i = 0; i < s.length(); i++) {
//    		char now = s.charAt(s.length()-i-1);
//    		if (now=='-') {
//    			return result*=-1;
//    		}
//    		else if (now == '+') {
//    			return result;
//    		}
//    		result += (now - '0')*Math.pow(10, i);
//    	}
//        return result;
//    }
	public static int solution(String s) {
		return Integer.parseInt(s);
	}
}
