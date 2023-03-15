package ps.BOJ._05000_05999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// 258,476kb
// 1,244ms

public class Main_5397_키로거 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		for (; N > 0; N--) {
			char[] inp = br.readLine().toCharArray();
			Stack<Character> pwL = new Stack<>();
			Stack<Character> pwR = new Stack<>();
			for (char c : inp) {
				switch (c) {
				case '<':
					if (!pwL.isEmpty())
						pwR.add(pwL.pop());
					break;
				case '>':
					if (!pwR.isEmpty())
						pwL.add(pwR.pop());
					break;
				case '-':
					if (!pwL.isEmpty())
						pwL.pop();
					break;
				default:
					pwL.add(c);
					break;
				}
			}
			while (!pwL.isEmpty())
				pwR.add(pwL.pop());
			while (!pwR.isEmpty())
				sb.append(pwR.pop());
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}