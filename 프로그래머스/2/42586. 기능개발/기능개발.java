import java.util.*;

class Solution {
    // queue를 이용하여 품
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < progresses.length; i++) {
            queue.add((int) Math.ceil((100.0-progresses[i])/speeds[i]));
        }

        while(!queue.isEmpty()) {
            int minDays = queue.poll();
            int count = 1;

            while(!queue.isEmpty() && queue.peek() <= minDays) {
                queue.poll();
                count++;
            }
            
            answer.add(count);
        }
        
        return answer;
    }
}