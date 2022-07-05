package study.day0705;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 40,872kb
// 576ms

public class Main_1655_가운데를_말해요 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static PriorityQueue<Integer> pq1 = new PriorityQueue<>((o1, o2) -> o2 - o1);
	static PriorityQueue<Integer> pq2 = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());

		pq1.add(Integer.parseInt(br.readLine()));
		sb.append(pq1.peek()).append("\n");
		for (int i = 1; i < N; i++) {
			int cur = Integer.parseInt(br.readLine());
			if (i % 2 == 0) {
				pq1.add(cur);
			} else {
				pq2.add(cur);
			}
			if (pq1.peek() > pq2.peek()) {
				int a = pq1.poll();
				int b = pq2.poll();
				pq1.add(b);
				pq2.add(a);
			}
			sb.append(pq1.peek()).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}