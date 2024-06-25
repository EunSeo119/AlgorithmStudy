import java.io.*;
import java.util.*;

/**
 * 풀이: (구현) LinkedList 이용, 데이터 중간에 삽입하는 경우 ArrayList 보다 뛰어난 성능을 가짐
 */
public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Integer> arr;
        StringBuilder sb;

        for(int t = 1; t <= 10; t++) {
            arr = new LinkedList<>();
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            int S = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < S; i++) {
                st.nextToken();
                int loc = Integer.parseInt(st.nextToken());
                int len = Integer.parseInt(st.nextToken());

                for(int j = 0; j < len; j++) {
                    arr.add(loc, Integer.parseInt(st.nextToken()));
                    loc++;
                }
            }

            System.out.print("#" + t + " ");

            sb = new StringBuilder();
            for(int i = 0; i < 10; i++) {
                sb.append(arr.get(i)).append(" ");
            }

            System.out.println(sb);
        }
    }
}
