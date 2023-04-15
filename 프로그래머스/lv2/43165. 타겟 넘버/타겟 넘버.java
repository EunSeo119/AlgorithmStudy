class Solution {
    static int N = 0;
    static int[] nums;
    static int result = 0;
    static int t;
    public int solution(int[] numbers, int target) {
        N = numbers.length;
        nums = numbers;
        t = target;
        subset();
        return result;
    }
    
    private static void subset() {
        for(int i = 0; i < (1<<N); i++){
            int sum = 0;
            for(int j = 0; j < N; j++){
                if((i & (1<<j))!=0){
                    sum -= nums[j];
                } else {
                    sum += nums[j];
                }
            }
            if(sum == t){
                result++;
            }
        }
    }
}