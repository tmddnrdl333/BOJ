package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// 148,068kb
// 780ms

public class Main_1406_에디터 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static Stack<Character> s1 = new Stack<>();
	static Stack<Character> s2 = new Stack<>();

	public static void main(String[] args) throws IOException {
		char[] init = br.readLine().toCharArray();
		for (char i : init)
			s1.add(i);
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			char command = st.nextToken().charAt(0);

			switch (command) {
			case 'L':
				if (!s1.isEmpty())
					s2.add(s1.pop());
				break;
			case 'D':
				if (!s2.isEmpty())
					s1.add(s2.pop());
				break;
			case 'B':
				if (!s1.isEmpty())
					s1.pop();
				break;
			case 'P':
				char p = st.nextToken().charAt(0);
				s1.add(p);
				break;
			}
		}

		while (!s1.isEmpty())
			s2.add(s1.pop());

		while (!s2.isEmpty())
			sb.append(s2.pop());

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}