import java.util.Arrays;

class Solution {
    public static String solution(String s) {
//    	char[] arr = new char[s.length()];
//    	for(int i = 0; i < s.length(); i++) {
//    		arr[i]=s.charAt(i);
//    	}
    	
    	char[] arr = s.toCharArray();
    	
    	Arrays.sort(arr);
    	
    	String result = "";
    	for (int i = s.length()-1; i >= 0; i--) {
    		result+=arr[i];
    	}
        return result;
    }
    
    public static void main(String[] args) {
		System.out.println(solution("Zbcdefg"));
	}
}
