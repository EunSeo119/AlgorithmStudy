class Solution {
    static int[] numbers;
    static boolean[] visited;
    static int[][] globalDungeons;
    static int dungeonCount;
    static int answer = -1;

    public int solution(int k, int[][] dungeons) {
        dungeonCount = dungeons.length;
        numbers = new int[dungeonCount];
        visited = new boolean[dungeonCount];
        globalDungeons = dungeons;

        perm(0, k);

        return answer;
    }

    private static void perm(int cnt, int k) {
        if(cnt == dungeonCount) {
            int count = 0;
            for(int i = 0; i < dungeonCount; i++) {
                if(globalDungeons[numbers[i]][0] > k) break;
                k-=globalDungeons[numbers[i]][1];
                count++;
            }

            answer = Math.max(count, answer);
            return;
        }
        for(int i = 0; i < dungeonCount; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            numbers[cnt] = i;
            perm(cnt+1, k);
            visited[i] = false;
        }
    }
}