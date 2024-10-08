import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(check(s)){
                answer++;   
            }
            s = s.substring(1) + s.substring(0, 1);
        }
        
        return answer;
    }
     
    private boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        boolean check = true;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '[' || ch == '('|| ch == '{') {
                stack.push(ch);
                continue;
            } 
            
            if(stack.isEmpty()) return false;
            
            char top = stack.pop();
            if(top == '[' && ch != ']' 
               || top == '{' && ch != '}' 
               || top == '(' && ch != ')') {
                return false;
            }
        }
        
        return stack.isEmpty();
    }
}