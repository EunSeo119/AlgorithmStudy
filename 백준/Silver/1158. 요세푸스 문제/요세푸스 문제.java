import java.io.*;
import java.util.*;

/**
 * (수학) 순서가 리스트 size 초과할 경우 %연산
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            list.add(i);
        }

        sb.append("<");
        int idx = 0;
        for(int i = 0; i < N; i++) {
            idx = (idx+K-1)%list.size();
            sb.append(list.remove(idx) + ", ");
        }

        System.out.println(sb.substring(0, sb.length()-2) + ">");
    }
}
