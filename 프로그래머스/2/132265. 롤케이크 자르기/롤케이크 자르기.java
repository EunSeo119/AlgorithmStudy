import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int len = topping.length;
        HashMap<Integer, Integer> end = new HashMap<>();
        for(int i = 0; i < len; i++) {
            end.put(topping[i], end.getOrDefault(topping[i], 0)+1);
        }
        
        HashMap<Integer, Integer> start = new HashMap<>();
        int result = 0;
        for(int i = 0; i < len-1; i++) {
            start.put(topping[i], start.getOrDefault(topping[i], 0)+1);
            end.put(topping[i], end.getOrDefault(topping[i], 1)-1);
            
            if(end.get(topping[i]) == 0) {
                end.remove(topping[i]);
            }
            
            if(start.size() == end.size()) {
                result++;
            }
        }
        return result;
    }
}