import java.util.Arrays;

class Solution {
    public static int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        int return_count = 0;
    	for(int[] check : commands) {
        	int[] temp = new int[check[1]-check[0]+1];
        	int count = 0;
        	for(int i = check[0]-1; i < check[1]; i++) {
        		temp[count] = array[i];
        		count++;
        	}
        	Arrays.sort(temp);
        	result[return_count++]=temp[check[2]-1];
        }
    	return result;
    }
    
    public static int[] solution2(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++){
            
            int[] arr = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(arr);
            answer[i] = arr[ commands[i][2]-1 ];

        }
        return answer;
    }
    
    // 테스트 코드
    public static void main(String[] args) {
    	System.out.println(solution2(new int[] {1,5,2,6,3,7,4}, new int[][] {{2,5,3},{4,4,1},{1,7,3}}));
    }
}
