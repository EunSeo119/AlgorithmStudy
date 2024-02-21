class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer=new int[photo.length];

        // 3중 for문으로 한번에 photo의 2차원 배열을 돌면서 하나씩 name 배열 포함 유무를 확인
        for(int i = 0; i < photo.length; i++) {
            for(int j = 0; j < photo[i].length; j++) {
                for(int k = 0; k < name.length; k++) {
                    if(photo[i][j].equals(name[k]))
                        answer[i] += yearning[k];
                }
            }
        }
        return answer;
    }
}