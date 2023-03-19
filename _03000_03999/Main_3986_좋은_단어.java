package ps.BOJ._03000_03999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// 23,032kb
// 252ms

public class Main_3986_좋은_단어 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int res = 0;
		for (; N > 0; N--) {
			char[] inp = br.readLine().toCharArray();
			Stack<Character> stack = new Stack<>();
			for (char c : inp) {
				if (!stack.isEmpty())
					if (c == stack.peek())
						stack.pop();
					else
						stack.add(c);
				else
					stack.add(c);
			}
			res += stack.size() == 0 ? 1 : 0;
		}
		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}