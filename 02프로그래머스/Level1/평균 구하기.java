class Solution {
    public static double solution(int[] arr) {
    	int sum = 0;
    	for(int i = 0; i < arr.length; i++) {
    		sum+=arr[i];
    	}
    	return (double)sum/arr.length;
    }
    
//    public static void main(String[] args) {
//    	int[] arr = {1,2,3,4};
//		System.out.println(solution(arr));
//	}
}
