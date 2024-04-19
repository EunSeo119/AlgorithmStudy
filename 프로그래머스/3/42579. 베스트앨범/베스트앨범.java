import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, List<int[]>> playsMap = new HashMap<>();
        HashMap<String, Integer> sumMap = new HashMap<>();
        List<Integer> tmpAnswer = new ArrayList<>();
        
        for(int i = 0; i < genres.length; i++) {
            if(!sumMap.containsKey(genres[i])) {
                sumMap.put(genres[i], 0);
                playsMap.put(genres[i], new ArrayList<>());
            }
            
            playsMap.get(genres[i]).add(new int[] {i, plays[i]});   // 앨범을 고유번호로 출력할 것이므로 고유번호와 값을 저장함(클래스를 만들어서 풀어도 될듯)
            sumMap.put(genres[i], sumMap.get(genres[i]) + plays[i]);
        }
        
        List<Map.Entry<String, Integer>> sortSumMap = new ArrayList<>(sumMap.entrySet());
        Collections.sort(sortSumMap, 
                   (Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) -> 
                  o2.getValue().compareTo(o1.getValue()));  // 내림차순
        
        for(int i = 0; i < sortSumMap.size(); i++) {
            String genre = sortSumMap.get(i).getKey();
            
            Collections.sort(playsMap.get(genre), (int[] o1, int[] o2) -> o2[1] - o1[1]);
            
            for(int j = 0; j < playsMap.get(genre).size(); j++){
                if(j > 1) break;
                tmpAnswer.add(playsMap.get(genre).get(j)[0]);
            }
        }
        
        int[] answer = new int[tmpAnswer.size()];
        for(int i = 0; i < tmpAnswer.size(); i++){
            answer[i] = tmpAnswer.get(i);
        }
        return answer;
    }
}