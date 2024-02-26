import java.util.*;

class Solution{
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        while (true) {
            int cnt = 0;
            
            for (int citation : citations) {
                if (citation >= answer) {
                    cnt++;
                }
            }
            
            if (answer > cnt) {
                answer--;
                break;
            }
            else {
                answer++;
            }
        }
        return answer;
    }
}