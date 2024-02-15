import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < numbers.length; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                if(!list.contains(numbers[i]+numbers[j])) {
                    list.add(numbers[i]+numbers[j]);
                }
            }
        }
        
        // stream을 이용해서 list를 오름차순 정렬하면서 int 배열로 변환
        return list.stream().sorted().mapToInt(i -> i).toArray();
    }
}