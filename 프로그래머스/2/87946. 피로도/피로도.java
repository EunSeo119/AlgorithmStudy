class Solution {
    static int N, answer;
    static int[] order;
    static int[][] gDungeons;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        gDungeons = dungeons;
        N = dungeons.length;
        order = new int[N];
        visited = new boolean[N];
        perm(0,k);
        return answer;
    }

    // 던전을 탐험하는 순서의 경우의 수를 순열로 체크한다.
    private void perm(int cnt, int k) {
        if(cnt == N) {
            int count = 0;
            for(int i = 0; i < N; i++) {
                if(gDungeons[order[i]][0] > k) break;

                k -= gDungeons[order[i]][1];
                count++;
            }
            // 해당 경우의 수에서 탐험할 수 있는 던전의 수가 더 크다면 정답 변수에 기록한다.
            answer = Math.max(count, answer);
        }

        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            order[cnt] = i;
            perm(cnt+1, k);
            visited[i] = false;
        }
    }
}