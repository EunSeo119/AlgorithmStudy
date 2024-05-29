import java.io.*;

public class Main {
    static int N = 9;
    static int R = 7;
    static int[] numbers, result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numbers = new int[9];
        result = new int[7];

        for(int i = 0; i < 9; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        comb(0, 0);
    }

    private static void comb(int start, int cnt) {
        if(cnt == R) {
            int sum = 0;
            for(int i = 0; i < 7; i++) {
                sum += result[i];
            }

            if(sum == 100) {
                for(int i = 0; i < 7; i++) {
                    System.out.println(result[i]);
                }
            }

            return;
        }

        for(int i = start; i < N; i++) {
            result[cnt] = numbers[i];
            comb(i+1, cnt+1);
        }
    }
}
