import java.util.*;

class Solution2 {
    static String[] arr;
    static List<String> list;
    public int solution(String word) {
        int answer = 0;
        
        list = new ArrayList<>();
        arr = new String[]{"A", "E", "I", "O", "U"};
        // 완전탐색 메서드 호출
        dfs(word, "", 0);
        
        // 선형 탐색
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
    
    // 완전탐색 메서드
    static void dfs(String word, String str, int depth) {
        list.add(str);
        
        if(depth == 5) {
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
            dfs(word, str + arr[i], depth + 1);
        }
    }
}

class Solution3 {
    static int idx = 0;
    static int answer = -1;
    public int solution(String word) {
        dfs(word, "");
        return answer;
    }
    public void dfs(String word, String text) {
        if(answer > 0) return;
        if(word.equals(text)) {
            answer=idx;
        }
        idx++;
        if(text.length()==5) {
            return;
        }

        dfs(word, text+"A");
        dfs(word, text+"E");
        dfs(word, text+"I");
        dfs(word, text+"O");
        dfs(word, text+"U");
    }
}

// Solution3에 나눠져있는 재귀호출을 반복문으로 한번에 처리
class Solution4 {
    List<String> list = new ArrayList<>();
    public int solution(String word) {
        dfs("", 0);
        return list.indexOf(word);
    }
    
    void dfs(String str, int len) {
        if(len > 5) return;
        
        list.add(str);
        
        for(int i = 0; i < 5; i++) {
            dfs(str + "AEIOU".charAt(i), len + 1);
        }
    }
}

/* 재귀호출(dfs)을 이용하지 않고 수학을 사용한 풀이
f(0) = 1
f(x) = f(x - 1) + 5^x
f(1) = 1 + 5^1 = 6
f(2) = 6 + 5^2 = 31
f(3) = 31 + 5^3 = 156
f(4) = 156 + 5^4 = 781
=> int[] increase = {781, 156, 31, 6, 1};
 */
class Solution {
    public int solution(String word) {
        HashMap<Character, Integer> alphabet = new HashMap<>();
        alphabet.put('A', 0);
        alphabet.put('E', 1);
        alphabet.put('I', 2);
        alphabet.put('O', 3);
        alphabet.put('U', 4);
        int[] increase = new int[] {781, 156, 31, 6, 1};
        
        int answer = word.length();
        
        for(int i = 0; i < word.length(); i++){
            answer += (increase[i] * alphabet.get(word.charAt(i)));
        }
        
        return answer;
    }
}