import java.util.*;

class Solution {
    static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==')' && !stack.isEmpty() && stack.peek()=='('){
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        if(!stack.isEmpty()) return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("(()("));
    }
}