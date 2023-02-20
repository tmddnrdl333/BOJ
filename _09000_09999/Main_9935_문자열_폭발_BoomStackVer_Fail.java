package ps.BOJ._09000_09999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// 47%..

public class Main_9935_문자열_폭발_BoomStackVer_Fail {
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
		Stack<Integer> bStack = new Stack<>();
		int p = 0;
		for (int i = 0; i < sl; i++) {
			sStack.push(str[i]);
			if (str[i] == boom[p]) {
				bStack.push(p++);
			} else if (p != 0) {
				if (str[i] == boom[0]) {
					bStack.push(0);
					p = 1;
				} else {
					bStack.clear();
					p = 0;
				}
			} else {
				bStack.clear();
			}

			if (p == bl) {
				int skip = 0;
				for (int j = 0; j < bl; j++) {
					bStack.pop();
					sStack.pop();
					while (str[i - j - skip] == '.')
						skip += bl;
					str[i - j - skip] = '.';
				}
				if (bStack.isEmpty())
					p = 0;
				else
					p = bStack.peek() + 1;
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