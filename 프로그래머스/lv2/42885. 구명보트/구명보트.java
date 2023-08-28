import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int index = 0;

        for(int i = people.length-1; i >= index; i--) {
            if(people[i] + people[index] <= limit) { // 2사람 탐
                index++;    // 해당 인덱스 (가벼운)사람은 이제 안탐
                answer++;
            } else {    // (무거운사람) 1사람만 탐
                answer++;
            }
        }
        return answer;
    }
}