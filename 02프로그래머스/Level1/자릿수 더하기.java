public class Solution {
    public static int solution(int n) {
//    	String str = Integer.toString(n);
//    	int result = 0;
//    	for(int i = 0; i < str.length(); i++) {
//    		result += Integer.parseInt(str.substring(i, i+1));
//    	}
    	
    	int result = 0;
    	while(true) {
    		result+=n%10;
    		if(n<10)
    			break;
    		n=n/10;
    	}

        return result;
    }
}
