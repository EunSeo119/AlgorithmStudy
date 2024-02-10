class Solution {
    public int solution(String s) {
        String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i = 0; i < strArr.length; i++) {
            // 문자열 s에 해당 영단어가 있다면 replace를 사용해 한번에 해당되는 단어를 전부 변환
            if(s.contains(strArr[i])) {
                s = s.replace(strArr[i], Integer.toString(i));
            }
        }
        return Integer.parseInt(s);
    }
}