import java.util.*;

class Solution {
    // queue를 이용하여 품
    public ArrayList<Integer> solution2(int[] progresses, int[] speeds) {
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
    
    // for문 + 이중 while문을 -> 한번의 for 문으로 개선
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < speeds.length; i++) {
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int date = (int) Math.ceil(remain);

            if (!q.isEmpty() && q.peek() < date) {
                answerList.add(q.size());
                q.clear();
            }

            q.offer(date);
        }

        answerList.add(q.size());

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}