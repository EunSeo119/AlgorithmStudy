import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		HashSet<String> wordsSet = new HashSet<>();
		for(int i = 0; i < N; i++) {
			wordsSet.add(sc.next());
		}
		List<String> wordsList = new ArrayList<>(wordsSet);
		
//		Collections.sort(wordsList,new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				if(o1.length()==o2.length()) {
//					return o1.compareTo(o2);
//				} else {
//					return o1.length() - o2.length();
//				}
//			}
//			
//		});
		
		Collections.sort(wordsList,(o1, o2)-> {
			if(o1.length()==o2.length()) {
				return o1.compareTo(o2);
			} else {
				return o1.length() - o2.length();
			}
		});
		
		for(int i = 0; i < wordsList.size(); i++) {
			System.out.println(wordsList.get(i));
		}
	}
}
