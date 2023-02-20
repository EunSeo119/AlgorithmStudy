import java.util.Scanner;

public class Main {
	static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int size = (int) Math.pow(2, N);
		
		cut(r,c,size);
		System.out.println(count);
	}

	private static void cut(int r, int c, int size) {
		if(size==0) return;
		
		if(r<(size/2) && c<(size/2)) {
			cut(r, c, size/2);
		}
		else if(r<(size/2) && c>=(size/2)) {
			count+=((size*size)/4)*1;
			cut(r, c-(size/2), size/2);
		}
		else if(r>=(size/2) && c<(size/2)) {
			count+=((size*size)/4)*2;
			cut(r-(size/2), c, size/2);
		}
		else if(r>=(size/2) && c>=(size/2)) {
			count+=((size*size)/4)*3;
			cut(r-(size/2), c-(size/2), size/2);
		}
	}
}
