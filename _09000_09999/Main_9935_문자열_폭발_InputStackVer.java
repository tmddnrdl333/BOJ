package ps.BOJ._09000_09999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// 39,340kb
// 380ms

public class Main_9935_문자열_폭발_InputStackVer {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static char[] str;
	static char[] boom;

	public static void main(String[] args) throws IOException {
		String input = br.readLine();
		str = input.toCharArray();
		boom = br.readLine().toCharArray();
		int sl = str.length;
		int bl = boom.length;

		Stack<Character> sStack = new Stack<>();
		for (int i = 0; i < sl; i++) {
			sStack.push(str[i]);
			if (sStack.size() >= bl) {
				boolean flag = true;
				for (int j = 0; j < bl; j++) {
					if (sStack.get(sStack.size() - 1 - j) != boom[bl - 1 - j]) {
						flag = false;
						break;
					}
				}
				if (flag) {
					for (int j = 0; j < bl; j++)
						sStack.pop();
				}
			}
		}

		for (char c : sStack) {
			sb.append(c);
		}

		bw.write(sb.length() == 0 ? "FRULA" : sb.toString());
		bw.flush();
		bw.close();
	}
}