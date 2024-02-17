import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        // 우선순위 큐 사용하여 실행시킬 우선순위가 높은 순으로 정렬하여 저장함
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // 실행대기 큐(현재 대기중인 프로세스의 우선순위와 인덱스 값을 배열로 묶어 넣을 예정)
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < priorities.length; i++) {
            pq.offer(priorities[i]);
            queue.offer(new int[] {priorities[i], i});
        }

        while(!pq.isEmpty()) {
            int node[] = queue.poll();

            if(node[0] == pq.peek()) {
                pq.poll();
                if(node[1] == location) {
                    return answer;
                }
                answer++;
                continue;
            }

            queue.offer(node);
        }
        return answer;
    }
}