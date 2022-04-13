package study.day0412;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 12,124kb
// 96ms

public class Main_13904_과제 {
	static class hw implements Comparable<hw> {
		int d, w;

		public hw(int d, int w) {
			super();
			this.d = d;
			this.w = w;
		}

		@Override
		public int compareTo(hw o) {
			return o.w - this.w;
		}

	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N;
	static PriorityQueue<hw> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			pq.offer(new hw(a, b));
		}

		boolean[] v = new boolean[1001];
		int sum = 0;
		while (!pq.isEmpty()) {
			hw cur = pq.poll();
			int d = cur.d;
			int w = cur.w;
			while (d != 0 && v[d]) {
				d--;
			}
			if (d != 0) {
				v[d] = true;
				sum += w;
			}
		}

		bw.write(Integer.toString(sum));
		bw.flush();
		bw.close();
	}
}