class Solution {
    // subset(부분조합)으로 풀기
    public int solution2(int[] numbers, int target) {
        int answer = 0;
        int N = numbers.length;

        for(int i = 0; i < (1<<N); i++){
            int sum = 0;
            for(int j = 0; j < N; j++){
                if((i & (1<<j)) != 0){
                    sum -= numbers[j];
                } else {
                    sum += numbers[j];
                }
            }
            if(sum == target){
                answer++;
            }
        }
        return answer;
    }

    // DFS로 풀기
    public static int solution(int[] numbers, int target) {
        int answer = dfs(numbers, target, 0, 0);
        return answer;
    }

    public static int dfs(int[] numbers, int target, int idx, int sum) {
        if (idx == numbers.length) {
            return sum == target ? 1 : 0;
        } else {
            return dfs(numbers, target, idx + 1, sum + numbers[idx]) + dfs(numbers, target, idx + 1, sum - numbers[idx]);
        }
    }
}