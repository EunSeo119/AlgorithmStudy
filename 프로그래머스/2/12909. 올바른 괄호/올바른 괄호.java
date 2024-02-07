import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char check = s.charAt(i);

            if(check == '(') {
                stack.add(check);
                continue;
            }

            if(stack.isEmpty()) {
                return false;
            }
            stack.pop();
        }

        if(!stack.isEmpty()) return false;

        return answer;
    }
}