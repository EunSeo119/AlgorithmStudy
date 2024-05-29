import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] numbers = new int[N+1];
        numbers[1] = Integer.parseInt(st.nextToken());
        for(int i = 2; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            numbers[i] = numbers[i-1] + num;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            System.out.println(numbers[end] - numbers[start-1]);
        }
    }
}
