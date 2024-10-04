class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(!s.equals("1")) {
            int cntOne = 0;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '0') {
                    answer[1]++;
                } else {
                    cntOne++;
                }
            }
            
            // int temp = Integer.parseInt(cntOne, 2);  // string -> int
            s = Integer.toBinaryString(cntOne);  // int -> string
            
            answer[0]++;           
        }
        
        return answer;
    }
}