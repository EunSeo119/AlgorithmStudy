import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        // PriorityQueue(우선순위 큐)는 들어가는 순서와는 상관없이 우선순위가 높은 데이터가 먼저 나가는 자료구조
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville) {
            pq.offer(s);
        }

        while(pq.peek() < K) {
            // pq의 사이즈가 2 이하이면 더이상 섞을 수 없다.
            if(pq.size() < 2) {
                return -1;
            }

            pq.offer(pq.poll() + (pq.poll()*2));
            
            answer++;
        }
        
        return answer;
    }
}