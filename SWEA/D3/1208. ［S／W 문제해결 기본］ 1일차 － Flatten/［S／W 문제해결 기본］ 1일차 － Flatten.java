import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t = 0; t < 10; t++) {
			int dump = sc.nextInt();
			int boxs[] = new int[100];
			for(int i = 0; i < 100; i++) boxs[i]=sc.nextInt();

			int result = 0;
			Arrays.sort(boxs);
			while(dump!=0) {
				boxs[boxs.length-1]--;
				boxs[0]++;
				Arrays.sort(boxs);
				result = boxs[boxs.length-1]-boxs[0];
				dump--;
				if(boxs[boxs.length-1]-boxs[0]==0) {
					break;
				}
			}
			System.out.printf("#%d %d", t+1, result);
			System.out.println();
		}
	}
}
