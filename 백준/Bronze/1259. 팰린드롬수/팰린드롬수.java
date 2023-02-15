import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String word = sc.next();
			if(word.equals("0")) {
				break;
			}
			
			boolean check = true;
			
			char temp[] = new char[word.length()/2+1];
			
			for(int i = 0; i < word.length()/2+1; i++) {
				temp[i] = word.charAt(i);
			}
			
			for(int i = 0; i < word.length()/2+1; i++) {
				if(temp[i] != word.charAt(word.length()-1-i)) {
					check = false;
				}
			}
			
			if(check) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}
