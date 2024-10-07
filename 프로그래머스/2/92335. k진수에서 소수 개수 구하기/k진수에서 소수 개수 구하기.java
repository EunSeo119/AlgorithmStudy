import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String str = Integer.toString(n, k);
        String temp = "";
        
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '0') {
                if(temp.equals("")) continue;
                
                answer += checkPrime(Long.parseLong(temp));
                temp = "";
                continue;
            }
            
            temp += str.charAt(i);
        }
        
        if(!temp.equals("")) {
            answer += checkPrime(Long.parseLong(temp));
        }
        
        return answer;
    }
    
    // 소수면 1, 아니면 0
    private int checkPrime(Long num) {
        if(num == 1) return 0;
        
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num%i == 0) return 0;
        }
        
        return 1;
    }
}