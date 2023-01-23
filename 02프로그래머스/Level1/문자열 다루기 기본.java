class Solution {
    public static boolean solution(String s) {
    	int count = 1;
    	if (s.length()==4||s.length()==6) {
//    		for(int i = 0; i < s.length(); i++) {
//    			if(s.charAt(i)>=48 && s.charAt(i)<=57) {
//    				count++;
//    			}
//    		}
    		count = s.split("[0-9]").length;
    	}
    	if(count==0) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public boolean solution2(String s) {
        boolean answer = false;
        char[] arr = s.toCharArray();
        
        if(arr.length == 4 || arr.length == 6){
           for(int i = 0; i < arr.length; i++){
             if ('0' <= arr[i] && arr[i] <='9'){
                 answer = true;
             }
             else{
                 answer = false;
                 break;
             }
           } 
        }
        
    return answer;    
    }
	
	public static boolean solution3(String s) {
	      if(s.length() == 4 || s.length() == 6){
	          try{
	              int x = Integer.parseInt(s);
	              return true;
	          } catch(NumberFormatException e){
	              return false;
	          }
	      }
	      else return false;
	  }
    
    // 테스트 코드
    public static void main(String[] args) {
		System.out.println(solution("a234"));
	}
}
