import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
class Solution {
    public List<Integer> solution(int[] answers) {
        int[][] people = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        List<Integer> result = new ArrayList<>();
        int[] count = new int[3];
        int max = 0;
        for(int i = 0; i < 3; i++){
            int[] check = people[i];
            int cLength = check.length;
            int correct = 0;
            for(int j = 0; j < answers.length; j++){
                if(answers[j]==check[j%cLength]){
                    correct++;
                }
            }
            max = Math.max(max, correct);
            count[i] = correct;
        }
        
        System.out.println(max);
        
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            if(count[i]==max){
                answer.add(i+1);
            }
        }
        return answer;
    }
}