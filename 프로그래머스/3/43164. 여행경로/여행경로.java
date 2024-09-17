import java.util.*;

class Solution {
    static int len;
    static String[] result;
    static boolean[] visited;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        len = tickets.length;
        result = new String[len+1];
        visited = new boolean[len];
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));   // 목적지 사전순 정렬
        
        for(int i = 0; i < len; i++) {
            if(tickets[i][0].equals("ICN")) {
                result[0] = "ICN";
                result[1] = tickets[i][1];
                visited[i] = true;
                if(dfs(1, tickets)) {
                    break;
                }
                visited[i] = false;
            }
        }
        
        
        
        return result;
    }
    
    private boolean dfs(int depth, String[][] tickets) {
        if(depth == len) {
            
            return true;
        }
        
        for(int i = 0; i < len; i++) {
            if(!visited[i] && tickets[i][0].equals(result[depth])) {
                result[depth+1] = tickets[i][1];
                visited[i] = true;
                
                if(dfs(depth+1, tickets)) {
                    return true;
                }
                
                visited[i] = false;
            }
        }
        
        return false;
    }
}