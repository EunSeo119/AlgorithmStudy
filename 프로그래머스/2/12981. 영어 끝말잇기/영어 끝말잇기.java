import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Map<String, Integer> map = new HashMap<>();
        int peopleNum = 0;
        map.put(words[0], 1);
        
        for(int i = 1; i < words.length; i++) {
            String preWord = words[i-1];
            String nowWord = words[i];
            
            char c1 = preWord.charAt(preWord.length()-1);
            char c2 = nowWord.charAt(0);
            
            if(map.containsKey(nowWord) || c1 != c2) {
                answer[0] = i%n+1;
                answer[1] = i/n+1;
                
                return answer;
            }
            
            map.put(nowWord, 1);
        }

        return answer;
    }
}