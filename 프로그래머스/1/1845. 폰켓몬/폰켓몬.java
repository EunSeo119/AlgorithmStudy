import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int max = nums.length/2;

        HashSet<Integer> numsSet = new HashSet<>();

        for(int num : nums) {
            numsSet.add(num);
        }

        if(numsSet.size() < max) {
            return numsSet.size();
        }

        return max;
    }
}