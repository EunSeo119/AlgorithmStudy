import java.util.*;

class Solution {
    // 조합을 이용하여 완전 탐색을 하면 런타임에러가남! -> Greedy 알고리즘을 이용해야함
    public String solution2(String number, int k) {
        StringBuilder answer = new StringBuilder();

        int start = 0;
        for (int i = 0; i < number.length()-k; i++) {
            int max = 0;
            for (int j = start; j <= i+k; j++) {
                if(max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    start = j+1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }
    
    // stack을 이용해서 풀수도 있다!
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}