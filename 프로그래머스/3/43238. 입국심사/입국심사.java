import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 0;
        long right = (long)n * times[0];
        
        long result = 0;
        while(left <= right) {
            long mid = (left + right)/2;
            
            long sum = 0;
            for(int i = 0; i < times.length; i++) {
                sum += mid/times[i];
            }
            
            if(sum < n) {   // mid 시간에 모든 사람이 검사받을 수 없을 경우
                left = mid+1;
            } else {
                right = mid-1;   // 모두 검사받을 수 있으나, 더 최솟값이 있을 수 있음
                result = mid;   // 일단 mid 값으로
            }
        }
        return result;
    }
}