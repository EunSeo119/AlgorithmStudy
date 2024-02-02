import java.util.*;

class Solution {
    static boolean[] visited;
    static List<Integer> numList;
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        numList = new ArrayList<>();
        for(int i = 1; i <= numbers.length(); i++){
            char[] output = new char[i];
            perm(0, i, numbers, output);
        }
        return numList.size();
    }

    // 순열을 이용하여 숫자의 조합을 구하고
    public void perm(int cnt, int N, String numbers, char[] output){
        if(cnt == N){
            String check = "";
            for(int i = 0; i < N; i++) {
                check += output[i];
            }
            int num = Integer.parseInt(check);
            // 해당 숫자의 조합이 소수인지 체크
            if(isPrime(num)){
                if(!numList.contains(num)) numList.add(num);
            }
            return;
        }
        for(int i = 0; i < numbers.length(); i++){
            if(visited[i]) continue;

            visited[i] = true;
            output[cnt] = numbers.charAt(i);
            perm(cnt + 1, N, numbers, output);
            visited[i] = false;
        }
    }

    public boolean isPrime(int n){
        if(n < 2) return false;
        for(int i = 2; i*i <= n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}