import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int breidge_sum = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < truck_weights.length; i++) {
            int current_truck = truck_weights[i];
            
            while(true) {
                if(queue.isEmpty()) {
                    queue.offer(current_truck);
                    breidge_sum += current_truck;
                    answer++;
                    break;
                }
                if(queue.size() == bridge_length){
                    breidge_sum -= queue.poll();
                    continue;
                } 
                if(current_truck+breidge_sum <= weight) {
                    queue.offer(current_truck);
                    breidge_sum += current_truck;
                    answer++;
                    break;
                }
                
                queue.offer(0);
                answer++;
            }
        }
        return answer + bridge_length;
    }
}