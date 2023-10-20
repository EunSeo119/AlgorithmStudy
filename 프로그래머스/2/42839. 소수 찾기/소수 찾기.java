import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    static int N, R;
    static char[] arr, input;
    static boolean[] visited;
    static List<Integer> result;
    static String check;
    static Set<Integer> set = new HashSet<Integer>();
    public static int solution(String numbers) {
        N = numbers.length();
        input = new char[N];

        for(int i = 0; i < N; i++) {
            input[i] = numbers.charAt(i);
        }

        for(int i = 1; i <= N; i++) {
            visited = new boolean[N];
            R = i;
            arr = new char[R];
            check = "";
            perm(0);
        }

        return set.size();
    }

    public static void perm(int cnt) {
        if(cnt == R) {
            for(int i = 0; i < R; i++) {
                check += arr[i];
            }
            if(!check.equals("") && isPrime(Integer.parseInt(check))) {
                set.add(Integer.valueOf(check));
            }
            check="";
            return;
        }
        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            arr[cnt] = input[i];
            perm(cnt+1);
            visited[i] = false;
        }
    }

    public static boolean isPrime(int n){
        if(n < 2) return false;

        for(int i = 2; i*i <= n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("1231"));
    }
}