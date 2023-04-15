import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        for(int i = 0; i < commands.length; i++){
            int[] command = commands[i];
            int[] cut = new int[command[1]-command[0]+1];
            int cnt = 0;
            for(int j = command[0]-1; j< command[1]; j++){
                cut[cnt++] = array[j];
            }
            Arrays.sort(cut);
            System.out.println(Arrays.toString(cut));
            
            result[i] = cut[command[2]-1];
        }
        
        return result;
    }
}