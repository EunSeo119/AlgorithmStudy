import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clothesTypeMap = new HashMap<>();

        for(int i = 0; i < clothes.length; i++) {
            // 이미 있는 의상 종류일 때
            if(clothesTypeMap.containsKey(clothes[i][1])) {
                clothesTypeMap.put(clothes[i][1], clothesTypeMap.get(clothes[i][1])+1);
                continue;
            }

            clothesTypeMap.put(clothes[i][1], 1);
        }

        Set<String> keySet = clothesTypeMap.keySet();
        for(String key : keySet) {
            // 해당 의상을 입지 않았을 경우의 수 하나 더 더해준뒤 경우의 수를 구한다
            answer *= clothesTypeMap.get(key)+1;
        }

        // 다 벗을 경우는 제외
        return answer-1;
    }
}