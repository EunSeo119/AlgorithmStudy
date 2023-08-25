/*
f(0) = 1
f(x) = f(x - 1) + 5^x
f(1) = 1 + 5^1 = 6
f(2) = 6 + 5^2 = 31
f(3) = 31 + 5^3 = 156
f(4) = 156 + 5^4 = 781
=> int[] increase = {781, 156, 31, 6, 1};
 */
class Solution {
    public int solution(String word) {
        String alphabet = "AEIOU";
        int[] increase = {781, 156, 31, 6, 1};

        int answer = word.length();

        for(int i = 0; i < word.length(); i++) {
            answer += (increase[i] * alphabet.indexOf(word.charAt(i)));
        }
        return answer;
    }
}