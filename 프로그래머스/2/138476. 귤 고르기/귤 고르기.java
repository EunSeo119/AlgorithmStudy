import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine);
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++) {
            hm.put(tangerine[i], hm.getOrDefault(tangerine[i], 0)+1);
        }
        
        List<Integer> list = new ArrayList<>(hm.values());
        Collections.sort(list, Collections.reverseOrder());
        
        int sum = 0;
        for(int value : list) {
            if(k <= sum) break;
            
            sum += value;
            answer++;
        }
        
        return answer;
    }
}