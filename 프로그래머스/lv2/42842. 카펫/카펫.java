class Solution {
    // yellow 약수 구하면서 구한 약수로 구한 brown 수랑 맞는 값 return
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for(int i = 1; i <= Math.sqrt(yellow); i++) {
            if(yellow%i == 0) {
                if((i+2)*2+(yellow/i*2) == brown) {
                    answer[0] = yellow/i+2;
                    answer[1] = i+2;
                }

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] result = solution(18,6);
        System.out.println(result[0] + "&" + result[1]);
    }
}