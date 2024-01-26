class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        // 약수 구하는 공식을 이용하여 yellow의 약수를 구한다
        for(int i = 1; i <= Math.sqrt(yellow); i++) {
            if(yellow % i == 0) {
                // 약수이면서 brown의 개수도 충족시키는 값을 찾으면 return 한다.
                if((yellow/i+2)*2 + i*2 == brown) {
                    answer[0] = (yellow/i+2);
                    answer[1] = i+2;
                    return answer;
                }
            }
        }
        return answer;
    }
}