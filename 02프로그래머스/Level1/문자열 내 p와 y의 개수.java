class Solution {
    static boolean solution(String s) {
        boolean answer = true;
        int pCount = 0;
        int yCount = 0;

        for(int i = 0; i < s.length(); i++) {
        	if(s.charAt(i)=='p'||s.charAt(i)=='P'){
        		pCount+=1;
        	}
        	else if(s.charAt(i)=='y'||s.charAt(i)=='Y'){
        		yCount+=1;
        	}
        }
    	if(pCount!=yCount) {
    		answer = false;
    	}
    	return answer;
    }
	
//	static boolean solution(String s) {
//        s = s.toLowerCase();
//        int count = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//
//            if (s.charAt(i) == 'p')
//                count++;
//            else if (s.charAt(i) == 'y')
//                count--;
//        }
//
//        if (count == 0)
//            return true;
//        else
//            return false;
//    }
    
    public static void main(String[] args) {
		System.out.println(solution("pPoooyY"));
	}
}
