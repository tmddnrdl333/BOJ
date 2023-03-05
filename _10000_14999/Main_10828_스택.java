package ps.BOJ._10000_14999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// 16,960kb
// 140ms

public class Main_10828_스택 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			char c1 = command.charAt(0);
			char c2 = command.charAt(1);
			switch (c1) {
			case 'p':
				if (c2 == 'u')
					stack.push(Integer.parseInt(st.nextToken()));
				else
					sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
				break;
			case 's':
				sb.append(stack.size()).append("\n");
				break;
			case 'e':
				sb.append(stack.isEmpty() ? 1 : 0).append("\n");
				break;
			case 't':
				sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
				break;
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}