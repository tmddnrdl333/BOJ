package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// 17,176kb
// 160ms

public class Main_4949_균형잡힌_세상 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static String YES = "yes\n";
	static String NO = "no\n";

	public static void main(String[] args) throws IOException {
		while (true) {
			char[] inp = br.readLine().toCharArray();
			if (inp.length == 1 && inp[0] == '.')
				break;
			Stack<Character> stack = new Stack<>();
			boolean flag = true;
			for (char c : inp) {
				if (c == '[')
					stack.add('[');
				else if (c == '(')
					stack.add('(');
				else if (c == ']') {
					if (stack.isEmpty()) {
						flag = false;
						break;
					}
					char tmp = stack.pop();
					if (tmp == '[')
						continue;
					else {
						flag = false;
						break;
					}
				} else if (c == ')') {
					if (stack.isEmpty()) {
						flag = false;
						break;
					}
					char tmp = stack.pop();
					if (tmp == '(')
						continue;
					else {
						flag = false;
						break;
					}
				}
			}
			if (stack.size() != 0)
				flag = false;
			if (flag)
				sb.append(YES);
			else
				sb.append(NO);
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}