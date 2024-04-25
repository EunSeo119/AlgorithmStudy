import java.util.*;
class Solution {
    public List<Long> solution(int n, long left, long right) {
        
        List<Long> list = new ArrayList<>();
        
        for(long i = left; i < right + 1; i++){
             list.add(Math.max(i/n, i%n) + 1);
        }
        
        return list;
    }
    
    // 메모리 초과
    public int[] solution2(int n, long left, long right) {
        List<Integer> answer = new ArrayList<>();
        int[][] arr = new int[n][n];
        int count = 0;
        boolean inputCheck = false;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = (Math.max(i, j) + 1);
                if(count == left) {
                    inputCheck = true;
                }
                if(inputCheck) {
                    answer.add(arr[i][j]);
                }
                if(count == right) {
                    int[] result = answer.stream().mapToInt(Integer::intValue).toArray();
                    return result;
                }
                count++;
            }
        }
        // Integer[] result = answer.toArray(new Integer[answer.size()]);
        // int[] result = answer.stream().mapToInt(Integer::intValue).toArray();
        
        return new int[] {};
    }
}