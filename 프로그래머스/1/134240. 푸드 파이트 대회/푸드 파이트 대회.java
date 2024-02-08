class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuffer sb = new StringBuffer(answer);

        for(int i = 1; i < food.length; i++) {
            int plusCount = food[i] / 2;
            // 자바 11부터는 repeat 함수를 통해 문자열을 원하는 수만큼 반복하여 나열할 수 있다.
            sb.append(String.valueOf(i).repeat(plusCount));
//            for(int j = 0; j < plusCount; j++) {
//                sb.append(i);
//            }
        }

        // StringBuffer를 사용하면 문자열을 반복문 없이 거꾸로 뒤집을 수 있다.
        answer += sb + "0";
        answer += sb.reverse(); // stringbuffer += 연산자로 자동 형변환 돼서 .toString() 생략해도 됨

        return answer;
    }
}