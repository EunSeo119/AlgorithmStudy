import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] result = new String[numbers.length];

        // int[] -> String[] 변환
        for (int i = 0; i < numbers.length; i++) {
            result[i] = String.valueOf(numbers[i]);
        }

        // String[] 배열 내림차순 정렬
        // Arrays.sort(result, new Comparator<String>() {
        //     @Override
        //     public int compare(String o1, String o2) {
        //         return (o2 + o1).compareTo(o1 + o2);
        //     }
        // });
        
        // 람다 이용
        Arrays.sort(result, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if(result[0].equals("0")) return "0";
        
        return String.join("", result);
    }
}