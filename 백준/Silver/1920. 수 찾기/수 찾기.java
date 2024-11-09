import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] array = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int number = Integer.parseInt(st.nextToken());
            System.out.println(find(array, number));
        }
    }

    static int find(int[] array, int number){
        int start = 0;
        int end = array.length - 1;
        while(start <= end){
            int mid = (end + start) / 2;
            if(number == array[mid]){
                return 1;
            }
            else if(number > array[mid]){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return 0;
    }
}
