import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> q = new LinkedList<>();
        int answer = 1;

        for(int i = 0; i < priorities.length; i++) {
            pq.offer(priorities[i]);
            q.offer(new int[]{i, priorities[i]});
        }

        while(!pq.isEmpty()) {
            int[] node = q.poll();
            if(node[1] == pq.peek()) {
                pq.poll();
                if(node[0] == location) {
                    return answer;
                }
                answer++;
                continue;
            }
            q.offer(node);
        }

        return answer;
    }
}