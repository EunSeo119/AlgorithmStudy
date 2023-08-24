import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        for(String operation : operations) {
            String[] s = operation.split(" ");
            if(s[0].equals("I")) {
                min.add(Integer.valueOf(s[1]));
                max.add(Integer.valueOf(s[1]));
            }
            else if(!min.isEmpty() && s[0].equals("D") && s[1].equals("1")) {
                int num = max.poll();
                min.remove(num);
            }
            else if(!min.isEmpty() && s[0].equals("D") && s[1].equals("-1")) {
                int num = min.poll();
                max.remove(num);
            }
        }

        if(min.isEmpty()) {
            return new int[] {0, 0};
        } else {
            return new int[] {max.poll(), min.poll()};
        }
    }
}