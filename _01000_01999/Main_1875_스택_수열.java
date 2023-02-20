package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// 28,964kb
// 288ms

public class Main_1875_스택_수열 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());

		int s = 1;
		Stack<Integer> stack = new Stack<>();
		stack.push(s++);
		sb.append("+\n");

		outer: for (int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(br.readLine());

			if (s < tmp) {
				// s를 push해야 함. (while로 맞출 때까지)
				while (s != tmp + 1) {
					stack.push(s++);
					sb.append("+\n");
				}
				stack.pop();
				sb.append("-\n");
			} else if (s == tmp) {
				// s를 push하고 바로 pop하면 끝
				stack.push(s++);
				stack.pop();
				sb.append("+\n-\n");
			} else {
				// s를 push하면 안됨, pop해서 나올 때까지
				while (true) {
					if (stack.isEmpty()) {
						sb.setLength(0);
						sb.append("NO");
						break outer;
					}
					int pop = stack.pop();
					sb.append("-\n");
					if (pop == tmp)
						break;
				}
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}