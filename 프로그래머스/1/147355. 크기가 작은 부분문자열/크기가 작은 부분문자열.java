class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int cut = p.length();

        for(int i = 0; i <= t.length()-cut; i++) {
            if(Long.parseLong(t.substring(i,i+cut)) <= Long.parseLong(p)) {
                answer++;
            }
        }
        return answer;
    }
}