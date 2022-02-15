package study.day0214;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// 11616kb
// 76ms

public class study_boj_2529_부등호 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static boolean[] inp;
	static int k;

	public static void main(String[] args) throws IOException {
		k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		// inp : 입력값. true : ">"
		inp = new boolean[k];
		for (int i = 0; i < k; i++) {
			int tmp = st.nextToken().charAt(0);
			if (tmp == 62)
				inp[i] = true;
		}
		StringBuilder sb = new StringBuilder();

		// 1
		Stack<Integer> s = new Stack<>();
		s.push(9);
		int now = 8;
		for (int i = 0; i < k; i++) {
			if (inp[i]) {
				// > 전까지 있는거 다 출력
				while (!s.isEmpty()) {
					sb.append(s.pop() + "");
				}
			}
			s.push(now);

			now--;
		}
		while (!s.isEmpty()) {
			sb.append(s.pop() + "");
		}
		sb.append("\n");
		// 2
		s.push(0);
		now = 1;
		for (int i = 0; i < k; i++) {
			if (!inp[i]) {
				// > 전까지 있는거 다 출력
				while (!s.isEmpty()) {
					sb.append(s.pop() + "");
				}
			}
			s.push(now);

			now++;
		}
		while (!s.isEmpty()) {
			sb.append(s.pop() + "");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
