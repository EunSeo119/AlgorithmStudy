import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] check = br.readLine().split("");
			if(check[0].equals(".")) break;
			Stack<String> stack = new Stack<>();
			boolean result = true;
			for(String c : check) {
				if(c.equals("(") || c.equals("[")) {
					stack.push(c);
				}
				else if(c.equals(")")){
					if(stack.isEmpty() || !stack.peek().equals("(")) {
						result = false;
					} else {
						stack.pop();
					}
				}
				else if(c.equals("]")){
					if(stack.isEmpty() || !stack.peek().equals("[")) {
						result = false;
					} else {
						stack.pop();
					}
				}
			}
			if(!stack.isEmpty() || !result) {
				System.out.println("no");
			} else {
				System.out.println("yes");
			}
		}
	}
}
