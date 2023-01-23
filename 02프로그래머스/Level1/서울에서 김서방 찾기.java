class Solution {
    public static String solution(String[] seoul) {
    	int location = 0;
        for(int i = 0; i < seoul.length; i++) {
        	if(seoul[i].equals("Kim")) {
        		location=i;
        		break;
        	}
        }
        return "김서방은 " + location + "에 있다";
    }
    
    // 테스트 코드
    public static void main(String[] args) {
		System.out.println(solution(new String[] {"Jane","Kim"}));
	}
}
