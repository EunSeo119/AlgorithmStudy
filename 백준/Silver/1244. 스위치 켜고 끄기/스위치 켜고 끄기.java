import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int switchNum = Integer.parseInt(br.readLine());
        int[] arr = new int[switchNum+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= switchNum; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int stdNum = Integer.parseInt(br.readLine());

        for(int i = 0; i < stdNum; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(gender == 1) {
                for(int j = num; j <= switchNum; j+=num) {
                    arr[j] = (arr[j] == 0) ? 1 : 0;
                }
            } else {
                arr[num] = (arr[num] == 0) ? 1 : 0;

                int count = 1;
                while(num - count >= 1 && num + count <= switchNum && arr[num-count] == arr[num+count]) {
                    arr[num-count] = (arr[num-count] == 0) ? 1 : 0;
                    arr[num+count] = (arr[num+count] == 0) ? 1 : 0;
                    count++;
                }
            }
        }

        for(int i = 1; i <= switchNum; i++) {
            System.out.print(arr[i]+" ");
            if(i%20 == 0) {
                System.out.println();
            }
        }

    }
}
