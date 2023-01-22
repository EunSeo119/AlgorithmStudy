class Solution {
    public static String solution(int num) {
//    	return num%2==0? "Even" : "Odd";
    	if(num%2==0) {
    		return "Even";
    	} else {
    		return "Odd";
    	}
    }
    
    public static void main(String[] args) {
		System.out.println(solution(3));
		System.out.println(solution(4));
	}
}
