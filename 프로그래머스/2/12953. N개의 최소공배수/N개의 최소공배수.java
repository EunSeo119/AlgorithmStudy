class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int maxNum = arr[arr.length-1];
        int count = 0;
        boolean check = true;
        int checkNum = 0;
        do {
            check = true;
            count++;
            checkNum = maxNum*count;
            for(int i = 0; i < arr.length; i++) {
                if(checkNum % arr[i] != 0) {
                    check = false;
                }
            }
        } while(!check);
        
        return checkNum;
    }
}