import java.util.*;
class Solution {
    public static int[] solution(int[] array, int[][] commands) {
        int count = 0;
        int[] answer = new int[commands.length];
        for(int[] command : commands) {
            List<Integer> cut = new ArrayList<>();

            for(int i = command[0]-1; i < command[1]; i++) {
                cut.add(array[i]);
            }

            Collections.sort(cut);

            answer[count] = cut.get(command[2]-1);
            count++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,5,2,6,3,7,4}, new int[][] {{2,5,3}, {4,4,1},{1,7,3}}));
    }
}