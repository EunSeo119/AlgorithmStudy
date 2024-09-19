import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int len = works.length;
        for(int i = 0; i < len; i++) {
            pq.offer(works[i]);
        }
        
        int count = 0;
        while(count != n) {
            int now = pq.poll();
            
            if(now <= 0) {
                return 0;
            }
            
            pq.offer(now-1);
            count++;
        }
        
        long result = 0;
        for(int i = 0; i < len; i++) {
            int now = pq.poll();
            result += now*now;
        }
        return result;
    }
}