import java.util.*;

class Solution2 {
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

class Solution {

    static List<String> list = new ArrayList<>();
    static boolean visited[];

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];

        dfs(0, "ICN", "ICN", tickets);

        // 모든 경우를 다해본 뒤 경로가 2개 이상일 경우 나중에 정렬을 하는 방법!
        Collections.sort(list);

        return list.get(0).split(" ");
    }

    static void dfs(int depth, String now, String path, String[][] tickets){
        if (depth == tickets.length) {
            list.add(path);
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && now.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(depth+1, tickets[i][1], path + " " +tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}