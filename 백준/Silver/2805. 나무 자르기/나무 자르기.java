import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] trees = new int[N];
		int max = 0;
		for(int i = 0; i < N; i++) {
			trees[i] = sc.nextInt();
			if(trees[i]>max) {
				max = trees[i];
			}
		}
		
		int high = max;
		int low = 0;
		int mid = 0;
		int result = 0;
		while(low<=high) {
			mid = (high+low)/2;
			long count = 0;
			for(int i = 0; i < N; i++) {
				if(trees[i]>=mid) {
					count+=(trees[i]-mid);
				}
			}
			if(count>=M) {
				low=mid+1;
				if(mid>=result) {
					result = mid;
				}
			} else {
				high=mid-1;
			}
		}
		System.out.println(result);
	}
}
