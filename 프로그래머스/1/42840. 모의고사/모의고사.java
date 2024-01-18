import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static List<Integer> solution(int[] answers) {
        int[] onePeople = {1, 2, 3, 4, 5};
        int[] twoPeople = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] threePeople = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] correct = {0, 0, 0};

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == onePeople[i % onePeople.length]) {
                correct[0]++;
            }
            if(answers[i] == twoPeople[i % twoPeople.length]) {
                correct[1]++;
            }
            if(answers[i] == threePeople[i % threePeople.length]) {
                correct[2]++;
            }
        }

        int maxCheck = Arrays.stream(correct).max().getAsInt(); // 해당 배열 중에 가장 큰 수

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < 3; i++) {
            if(correct[i] == maxCheck) {
                result.add(i+1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,3,2,4,2}));
    }
}