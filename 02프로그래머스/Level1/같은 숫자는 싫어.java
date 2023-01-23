import java.util.*;

public class Solution {
    public static int[] solution(int []arr) {
    	int same = -1;
    	List<Integer> result = new ArrayList<>();
    	for(int i = 0; i < arr.length; i++) {
    		if(same!=arr[i]) {
    			result.add(arr[i]);
    			same=arr[i];
    		}
    	}

//        return result.stream().mapToInt(i -> i).toArray();
        
        int[] answer = new int[result.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = result.get(i).intValue();
        }
        return answer;
    }
    
    public static int[] solution2(int []arr) {
        
        int [] answer = new int[arr.length];
            
        int size = 0;
        answer[size++] = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == arr[i-1]){ continue;}
            else{
                answer[size++] = arr[i];
            }
        } 
        return Arrays.copyOf(answer, size);
    }
    
    // 테스트 코드
    public static void main(String[] args) {
		System.out.println(solution2(new int[] {1,1,3,3,0,1,1}));
	}
}
