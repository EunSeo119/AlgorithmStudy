import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            String P = br.readLine();
            int len = Integer.parseInt(br.readLine());
            String nums = br.readLine();

            Deque<Integer> deque = new LinkedList<>();
            for(String str : nums.substring(1, nums.length()-1).split(",")) {
                if (!str.equals("")) {
                    deque.add(Integer.parseInt(str));
                }
            }

            boolean reverse = false;
            boolean isError = false;
            for(int i = 0; i < P.length(); i++) {

                if(P.charAt(i) == 'R') {
                    reverse = !reverse;
                    continue;
                }

                if(deque.size() == 0) {
                    isError = true;
                    break;
                }

                if(P.charAt(i) == 'D' && reverse) {
                    deque.removeLast();
                    continue;
                }

                if(P.charAt(i) == 'D' && !reverse) {
                    deque.removeFirst();
                    continue;
                }

            }

            if(isError) {
                System.out.println("error");
                continue;
            }

            StringBuilder sb = new StringBuilder("[");
            while (!deque.isEmpty()) {
                if(reverse) {
                    sb.append(deque.removeLast());
                } else {
                    sb.append(deque.removeFirst());
                }

                if(deque.size() != 0) {
                    sb.append(",");
                }
            }

            sb.append("]");
            System.out.println(sb);
        }
    }
}
