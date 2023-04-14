class Solution {
	
	public static int solution(int[][] sizes) {
        int length = 0, height = 0;
        for (int[] card : sizes) {
            length = Math.max(length, Math.max(card[0], card[1]));
            height = Math.max(height, Math.min(card[0], card[1]));
        }
        int answer = length * height;
        return answer;
    }
	
    public static int solution2(int[][] sizes) {
    	int w_max = 0;
    	int h_max = 0;
    	
    	for(int i = 0; i < sizes.length; i++) {
    		int[] card = sizes[i];
    		
    		int w = card[0]>=card[1]? card[0]:card[1];
    		int h = card[0]>=card[1]? card[1]:card[0];
    		
    		w_max = Math.max(w, w_max);
    		h_max = Math.max(h, h_max);
    		
    	}
    	
        return w_max*h_max;
    }
    
    // 테스트 코드
    public static void main(String[] args) {
		System.out.println(solution(new int[][] {{60, 50},{30, 70},{60, 30},{80, 40}}));
	}
}