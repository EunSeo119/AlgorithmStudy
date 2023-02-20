import java.util.Arrays;
import java.util.Scanner;

class Member{
	int age;
	String name;
	
	Member(int age, String name){
		this.age = age;
		this.name = name;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Member[] arr = new Member[N];
		for(int i = 0; i < N; i++) {
			int age = sc.nextInt();
			String name = sc.next();
			Member m = new Member(age, name);
			arr[i] = m;
		}
		
		Arrays.sort(arr, (o1, o2)-> {return o1.age-o2.age;});
		
		for(int i = 0; i < N; i++) {
			System.out.print(arr[i].age +" "+ arr[i].name);
			System.out.println();
		}
	}
}
