package ps.BOJ._03000_03999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// 11,720kb
// 80ms

public class Main_3568_ISharp {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		while (true) {
			String input = br.readLine();
			if (input == null || input.isEmpty())
				break;

			Queue<Character> type1 = new LinkedList<>();
			Queue<Character> type2 = new LinkedList<>();

			st = new StringTokenizer(input);
			char[] token = st.nextToken().toCharArray();
			for (char t : token) {
				if (t >= 'A' && t <= 'Z' || t >= 'a' && t <= 'z')
					type1.add(t);
				else
					type2.add(t);
			}

			while (st.hasMoreTokens()) {

				Queue<Character> name = new LinkedList<>();

				for (char t1 : type1)
					sb.append(t1);
				for (char t2 : type2)
					sb.append(t2);
				token = st.nextToken().toCharArray();
				Stack<Character> type3 = new Stack<>();
				for (char t : token) {
					if (t >= 'A' && t <= 'Z' || t >= 'a' && t <= 'z')
						name.add(t);
					else if (t != ',' && t != ';')
						type3.add(t);
				}
				while (!type3.isEmpty()) {
					if (type3.peek() == ']') {
						sb.append("[]");
						type3.pop();
						type3.pop();
					} else
						sb.append(type3.pop());
				}
				sb.append(" ");
				while (!name.isEmpty()) {
					sb.append(name.poll());
				}
				sb.append(";\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}