import java.util.*;

public class Solution {
    public static int[] solution(int[] arr) {
        int same = -1;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(same != arr[i]) {
                result.add(arr[i]);
                same = arr[i];
            }
        }

        int[] answer = new int[result.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        // 리스트 스트림을 이용하여 배열로 바꾸기
//        answer = result.stream()
//            .mapToInt(Integer::intValue)
//            .toArray();
//
//        answer = result.stream()
//            .mapToInt(i -> i.intValue())
//            .toArray();
        
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,1,3,3,0,1,1}));
    }
}