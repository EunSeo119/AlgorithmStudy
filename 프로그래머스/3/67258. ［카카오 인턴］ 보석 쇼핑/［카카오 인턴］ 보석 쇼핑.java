import java.util.*;
// 슬라이딩 윈도우 활용
class Solution {
    public int[] solution(String[] gems) {
        HashSet<String> gemTypes = new HashSet<>(Arrays.asList(gems));   // 모든 보석의 종류 수
        int totalGemTypes = gemTypes.size();

        HashMap<String, Integer> hm = new HashMap<>();
        int start = 0, end = 0;
        int minLength = Integer.MAX_VALUE;
        int[] result = new int[2];

        while (end < gems.length) {
            hm.put(gems[end], hm.getOrDefault(gems[end], 0) + 1);
            end++;

            while (hm.size() == totalGemTypes) {
                // 최소 구간을 찾으면 결과 갱신
                if (end - start < minLength) {
                    minLength = end - start;
                    result[0] = start + 1;
                    result[1] = end;
                }

                // 윈도우의 시작을 줄여나가며 보석 개수를 줄임
                hm.put(gems[start], hm.get(gems[start]) - 1);
                if (hm.get(gems[start]) == 0) {
                    hm.remove(gems[start]);
                }
                start++;
            }
        }

        return result;
    }
}
