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

class Solution {
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