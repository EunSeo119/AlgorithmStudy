import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1;
        for(int i = 0; i < name.length(); i++) {
            answer += Math.min(Math.abs('A' - name.charAt(i)), 'Z' - name.charAt(i)+1);
            
            int idx = i + 1;
            while(idx < name.length() && name.charAt(idx) == 'A') {
                idx++;
            }
            
            move = Math.min(move, i + (name.length() - idx) + Math.min(i, name.length() - idx));
        }
        return answer + move;
    }
}