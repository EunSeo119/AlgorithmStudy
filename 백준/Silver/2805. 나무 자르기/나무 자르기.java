import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 풀이: 이분탐색 활용
 */
public class Main {
    static int[] tree;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        tree = new int[N];

        st = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if(tree[i] > max) {
                max = tree[i];  // 입력값 받을 때 찾을 수 있으면 잘 활용하기
            }
        }

        int start = 0;
        int end = max;
        int mid = -1;
        int result = 0;
        while(start <= end) {   // '=' 꼭 포함 해주기
            mid = (start + end) / 2;
            long cutTree = cut(mid);    // 나무 길이 20억이기 때문에 long
            if(cutTree == M) {
                result = mid;
                break;
            }

            if(cutTree > M) {
                if(mid > result) {
                    result = mid;
                }
                start = mid+1;  // 둘 다 더하고
                continue;
            }

            if(cutTree < M) {
                end = mid-1;    // 둘 다 빼기
                continue;
            }
        }

        System.out.println(result);
    }

    private static long cut(int mid) {
        long cutTree = 0;
        for(int i = 0; i < N; i++) {
            if(tree[i] > mid) {
                cutTree += tree[i] - mid;
            }
        }

        return cutTree;
    }
}
