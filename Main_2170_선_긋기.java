package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 323,716kb
// 1640ms

public class Main_2170_선_긋기 {

	static class Line implements Comparable<Line> {
		int from, to;

		Line(int from, int to) {
			this.from = from;
			this.to = to;
		}

		@Override
		public int compareTo(Line o) {
			return this.from - o.from;
		} // 시작점이 왼쪽일수록 우선
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N;
	static PriorityQueue<Line> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken());
			pq.offer(new Line(from, to));
		}

		Line first = pq.poll();
		int sum = 0;
		int start = first.from, end = first.to;

		while (!pq.isEmpty()) {
			Line cur = pq.poll();
			if (cur.from <= end) {
				end = end >= cur.to ? end : cur.to;
			} else {
				sum += end - start;
				start = cur.from;
				end = cur.to;
			}
		}
		sum += end - start;

		System.out.println(sum);
	}
}