import java.util.*;

class Solution {
    // HashSet의 contains를 이용하여 품
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        for(String phone : phone_book) {
            set.add(phone);
        }

        for(String phone : phone_book) {
            for(int i = 1; i < phone.length(); i++) {
                if(set.contains(phone.substring(0, i))) {
                    return false;
                }
            }
        }
        return true;
    }
}