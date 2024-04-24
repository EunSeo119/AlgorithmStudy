import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] numbers = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < numbers.length; i++){
            int number = Integer.parseInt(numbers[i]);
            
            min = Math.min(min, number);
            max = Math.max(max, number);
        }

        answer = min+ " " +max;
        return answer;
    }
    
    public String solution2(String s) {
        String answer = "";
        String[] strArr = s.split(" ");
        int[] intArr = new int[strArr.length];
        
        for(int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.valueOf(strArr[i]);
        }
        
        Arrays.sort(intArr);
        answer = String.valueOf(intArr[0]) + " " + String.valueOf(intArr[intArr.length-1]);
        return answer;
    }
}