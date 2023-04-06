package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 34,648kb
// 256ms

public class Main_2812_크게_만들기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		@SuppressWarnings("unused")
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		char[] inp = br.readLine().toCharArray();

		Deque<Integer> dq = new ArrayDeque<>();

		for (char c : inp) {
			int num = c - '0';

			while (K != 0 && !dq.isEmpty() && dq.peekLast() < num) {
				K--;
				dq.pollLast();
			}
			dq.add(num);

		}

		while (!dq.isEmpty())
			sb.append(dq.poll());

		sb.setLength(sb.length() - K);

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}