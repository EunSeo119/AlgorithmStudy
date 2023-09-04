import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville) {
            pq.offer(s);
        }

        while(pq.peek() < K) {
            if(pq.size() < 2) {
                return -1;
            }
            int A = pq.poll();
            int B = pq.poll();

            pq.offer(A+B*2);
            answer++;
        }
        return answer;
    }
}