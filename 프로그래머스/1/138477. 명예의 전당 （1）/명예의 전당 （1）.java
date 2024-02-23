import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < score.length; i++) {
            list.add(score[i]);
            // 리스트 내림차순으로 정렬
            Collections.sort(list, Collections.reverseOrder());
            if(list.size() < k) {
                answer[i] = list.get(list.size()-1);
                continue;
            }
            
            answer[i] = list.get(k-1);
        }
        return answer;
    }
}