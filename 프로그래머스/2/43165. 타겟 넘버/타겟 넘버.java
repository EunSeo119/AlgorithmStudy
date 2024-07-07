import java.util.*;
class Solution {
    static int result;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return result;
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