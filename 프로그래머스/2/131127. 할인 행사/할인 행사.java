import java.util.*;
class Solution {
    static HashMap<String, Integer> check;
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        check = new HashMap<>();
        HashMap<String, Integer> temp = new HashMap<>();
        
        int numLen = 0;
        for(int i = 0; i < number.length; i++) {
            numLen += number[i];
        }
        
        for(int i = 0; i < want.length; i++) {
            check.put(want[i], number[i]);
        }
        
        for(int i = 0; i < numLen; i++) {
            temp.put(discount[i], temp.getOrDefault(discount[i], 0)+1);
        }
        
        answer += check(temp);
        
        // 슬라이딩 윈도우
        for(int i = numLen; i < discount.length; i++) {
            String removeItem = discount[i - numLen];
            temp.put(removeItem, temp.get(removeItem)-1);
            
            if(temp.get(removeItem) == 0) {
                temp.remove(removeItem);
            }
            
            temp.put(discount[i], temp.getOrDefault(discount[i], 0)+1);
            answer += check(temp);
        }
        
        return answer;
    }
    
    private int check(HashMap<String, Integer> temp) {
        // HashMap은 equals로 비교 가능!
        if(check.equals(temp)) {
            return 1;
        }
        
        return 0;
    }
}