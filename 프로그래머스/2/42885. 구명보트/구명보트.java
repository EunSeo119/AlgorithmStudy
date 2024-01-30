import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int minIdx = 0;
        int maxIdx = people.length - 1;
        
        Arrays.sort(people);
        while(maxIdx >= minIdx){
            // 가장 무거운 사람을 가장 가벼운 사람이랑 같이 탔는데도 초과가 나면 혼자 구출해야함
            if(people[maxIdx] + people[minIdx] > limit){
                maxIdx--;
            } else{ // 초과가 나지 않으면 (남은 사람 중 가장)가벼운 사람, (남은 사람 중 가장)무거운 사람 한명씩 구출함
                maxIdx--;
                minIdx++;
            }
            answer++;
        }
        return answer;
    }
}