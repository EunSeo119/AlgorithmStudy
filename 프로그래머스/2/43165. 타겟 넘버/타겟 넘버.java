import java.util.*;
class Solution {
    static int result, N;
    public int solution(int[] numbers, int target) {
        // dfs 사용
        // dfs(numbers, target, 0, 0);
        
        // 부분조합 사용
        N = numbers.length;
        subset(numbers, target);
        return result;
    }
    
    static private void subset(int[] numbers, int target) {
        for(int i = 0; i < (1<<N); i++) {
            int sum = 0;
            for(int j = 0; j < N; j++) {
                if((i&(1<<j)) == 0) {
                    sum -= numbers[j];
                    continue;
                }
                
                sum += numbers[j];
            }
            
            if(sum == target) {
                result++;
            }
        }
    }
    
    static private void dfs(int[] numbers, int target, int sum, int cnt) {
        
        if(cnt == numbers.length) {
            if(sum == target) {
                result++;
                return;
            }
            
            return;
        }
        
        dfs(numbers, target, sum+numbers[cnt], cnt+1);
        dfs(numbers, target, sum-numbers[cnt], cnt+1);
        
    }
}