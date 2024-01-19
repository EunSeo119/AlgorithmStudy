import java.util.HashMap;

class Solution {
    public static String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> hm = new HashMap<>();

        for(String p : participant){
            hm.put(p, hm.getOrDefault(p, 0)+1);
        }

        for(String c : completion) {
            hm.put(c, hm.get(c)-1);
        }

        for(String key : hm.keySet()){
            if(hm.get(key) != 0){
                return key;
            }
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"}));
    }
}