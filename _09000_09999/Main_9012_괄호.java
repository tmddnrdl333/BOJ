package ps.BOJ._09000_09999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// 11,772kb
// 88ms

public class Main_9012_괄호 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		for (; N > 0; N--) {
			char[] inp = br.readLine().toCharArray();
			Stack<Character> stack = new Stack<>();
			for (char c : inp) {
				if (stack.isEmpty()) {
					stack.add(c);
				} else {
					if (stack.peek() == '(' && c == ')')
						stack.pop();
					else
						stack.add(c);
				}
			}
			if (stack.isEmpty())
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}