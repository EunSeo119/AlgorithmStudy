class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int result = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                result++;
                dfs(n, computers, i);
            }
        }
        return result;
    }
    
    public static void dfs(int n, int[][] computers, int node){
        visited[node] = true;
        
        for(int i = 0; i < n; i++){
            if(!visited[i] && computers[node][i]==1){
                dfs(n, computers, i);
            }
        }
    }
}