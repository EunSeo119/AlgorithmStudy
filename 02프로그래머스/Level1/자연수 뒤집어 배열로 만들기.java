import java.util.Arrays;

class Solution {
    public static int[] solution(long n) {
    	String str = String.valueOf(n);
    	int[] arr = new int[str.length()];
    	for(int i = 0; i < str.length(); i++ ) {
    		arr[i] = str.charAt(str.length() - i -1)-'0';
    	}
        return arr;
    }
    
//    public static int[] solution(long n) {
//        String a = "" + n;
//          int[] answer = new int[a.length()];
//          int cnt=0;
//
//          while(n>0) {
//              answer[cnt]=(int)(n%10);
//              n/=10;
//              cnt++;
//          }
//        return answer;
//    }
    
    // 테스트 코드
    public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(12345)));
	}
}
