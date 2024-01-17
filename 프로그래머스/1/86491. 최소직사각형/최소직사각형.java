class Solution {

    public static int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;

        for(int[] card : sizes) {
            maxW = Math.max(Math.max(card[0], card[1]), maxW);
            maxH = Math.max(Math.min(card[0], card[1]), maxH);
        }

        return maxW * maxH;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{60, 50},{30, 70},{60, 30},{80, 40}}));
    }

}
