import java.util.*;

class Solution {
    // HashSet의 contains를 이용하여 품
    public boolean solution2(String[] phone_book) {
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
    
    // 조금 더 개선한 코드
    public boolean solution(String[] phoneBook) {
        // 정렬을 하면 접두어가 같으면 앞뒤로 단어가 정렬되게 된다.
        Arrays.sort(phoneBook);
        for (int i = 0; i < phoneBook.length-1; i++) {
            // 하여 정렬 후 앞 단어가 뒤 단어에 포함이 되나만 확인하면 된다.
            if (phoneBook[i+1].startsWith(phoneBook[i])) {
                return false;
            }
        }
        return true;
    }
}