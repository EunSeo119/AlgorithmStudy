import java.util.*;
import java.io.*;

/**
 * 풀이: 조합 활용
 */
public class Main {
    static int L, C;
    static String[] alphabets, result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabets = new String[C];
        result = new String[L];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++) {
            alphabets[i] = st.nextToken();
        }
        Arrays.sort(alphabets);
        comb(0, 0);
    }

    private static void comb(int start, int cnt) {
        if(cnt == L) {
            String str = "";
            int moo = 0;
            int zaa = 0;
            for(int i = 0; i < L; i++) {
                if(result[i].equals("a") || result[i].equals("e") || result[i].equals("i") || result[i].equals("o") || result[i].equals("u")) {
                    moo++;
                } else {
                    zaa++;
                }
                str += result[i];
            }

            if(moo >= 1 && zaa >= 2) {
                System.out.println(str);
            }
            return;
        }

        for(int i = start; i < C; i++) {
            result[cnt] = alphabets[i];
            comb(i+1, cnt+1);
        }
    }
}
