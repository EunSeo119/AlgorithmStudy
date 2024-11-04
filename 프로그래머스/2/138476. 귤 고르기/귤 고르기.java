import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++) {
            hm.put(tangerine[i], hm.getOrDefault(tangerine[i], 0)+1);
        }
        
        for(int value : hm.values()) {
            pq.offer(value);
        }
        
        int sum = 0;
        while(k > sum) {
            sum += pq.poll();
            answer++;
        }
        
        return answer;
    }
}