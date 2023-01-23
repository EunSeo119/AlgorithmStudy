package com.ssafy.algo;

//import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;

class Solution {
	
	public static int[] solution(int[] arr, int divisor) {
        
        int count = 0;
        int resultCount = 0;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % divisor == 0){
                count++;
            }
        }
        
        if(count == 0){
            int[] answer = {-1};
            return answer;
        }
        
        int[] answer = new int[count];
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % divisor == 0){
                answer[resultCount] = arr[i];
                resultCount++;
            }
        }
        
        Arrays.sort(answer);
        return answer;
        
    }
	
//    public static int[] solution(int[] arr, int divisor) {
//        
//    	List<Integer> list = new ArrayList<>();
//    	for(int i = 0; i < arr.length; i++) {
//        	if(arr[i]%divisor==0) {
//        		list.add(arr[i]);
//        	}
//        }
//    	if(list.size()==0) {
//    		list.add(-1);
//    	}
//    	
//    	Collections.sort(list);
//    	Integer[] result = list.toArray(new Integer[0]);
//    	
//    	int[] answer = Arrays.stream(result).mapToInt(i -> i).toArray();
//    	
//        return answer;
//    }
    
    // 테스트 코드
    public static void main(String[] args) {
		System.out.println(solution(new int[] {5,9,7,10}, 5));
		System.out.println(solution(new int[] {3,2,6}, 5));
	}
}
