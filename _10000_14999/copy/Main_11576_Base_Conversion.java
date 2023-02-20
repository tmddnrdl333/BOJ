package ps.BOJ._10000_14999.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// 11,640kb
// 80ms

public class Main_11576_Base_Conversion {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int tenth = 0;
		for (int i = m - 1; i >= 0; i--)
			tenth += Integer.parseInt(st.nextToken()) * Math.pow(A, i);

		Stack<Integer> stack = new Stack<>();
		while (tenth != 0) {
			stack.push(tenth % B);
			tenth /= B;
		}
		while (!stack.isEmpty())
			sb.append(stack.pop() + " ");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}