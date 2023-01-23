class Solution {
    public static String solution(String phone_number) {
        String result = "";
        int size = phone_number.length();
    	for(int i = 0; i < size-4; i++) {
        	result+="*";
        }
    	
    	result+=phone_number.substring(size-4);
        return result;
    }
    public static void main(String[] args) {
		System.out.println(solution("0103334444"));
	}
}
