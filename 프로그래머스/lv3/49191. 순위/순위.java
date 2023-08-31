// 플로이드 와샬 알고리즘 이용
class Solution {
    public static int solution(int n, int[][] results) {
        int[][] floyd = new int[n+1][n+1];
        int answer = 0;

        for(int i = 0; i < results.length; i++) {
            int A = results[i][0];
            int B = results[i][1];

            floyd[A][B] = 1;    // A가 B를 이김
            floyd[B][A] = -1;   // B가 A에게 짐
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++) {
                    if(floyd[i][k]==1 && floyd[k][j]==1) {     // i번째가 k번째를 이기고 k번째가 j번째를 이기면
                        floyd[i][j] = 1;    // i번째가 j번째를 이긴다
                        floyd[j][i] = -1;   // j번째는 i번째에게 진다
                    }
                    if(floyd[i][k]==-1 && floyd[k][j]==-1) {    // i번째가 k번째에게 지고 k번째가 j번째에게 지면
                        floyd[i][j] = -1;   // i번째가 j번째에게 진다
                        floyd[j][i] = 1;    // j번째가 i번째를 이긴다
                    }
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            int count = 0;
            for(int j = 1; j <= n; j++) {
                if(floyd[i][j] != 0) count++;
            }

            if(count == n-1) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, new int[][] {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }
}