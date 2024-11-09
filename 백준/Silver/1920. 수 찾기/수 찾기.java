import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> hs = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            hs.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int check = Integer.parseInt(st.nextToken());
            if(hs.contains(check)) {
                System.out.println(1);
                continue;
            }

            System.out.println(0);
        }
    }
}
