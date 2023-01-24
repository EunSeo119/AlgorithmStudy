class Solution {
    public static String solution(String s) {
    	String[] arr = s.split("");
    	int count = 0;
    	String result = "";
    	for(int i = 0; i < s.length(); i++) {
    		if(arr[i].trim().isEmpty()) {
    			result+=" ";
    			count=0;
    		}
    		else {
    			if (count%2==0){
    				result+=arr[i].toUpperCase();
        			count++;
    			}
    			else {
    				result+=arr[i].toLowerCase();
        			count++;
    			}
    		}
    	}
    	return result;
    }
    
    // 테스트 
    public static void main(String[] args) {
		System.out.println(solution("Traa   HeLlO WoRlD "));
	}
}
