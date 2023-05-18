package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 294,204kb
// 536ms

public class Main_1158_요세푸스_문제 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++)
			q.add(i);

		sb.append("<");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K - 1; j++) {
				q.add(q.poll());
			}
			sb.append(q.poll() + ", ");
		}
		sb.setLength(sb.length() - 2);
		sb.append(">");

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}