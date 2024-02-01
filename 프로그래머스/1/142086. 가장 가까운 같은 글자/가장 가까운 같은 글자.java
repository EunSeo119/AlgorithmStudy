class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        for(int i = 0; i < s.length(); i++) {
            int idx = s.substring(0, i).lastIndexOf(s.charAt(i));

            if(idx == -1) {
                answer[i] = -1;
                continue;
            }

            answer[i] = i-idx;
        }
        return answer;
    }
}