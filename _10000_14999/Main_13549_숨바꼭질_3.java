package ps.BOJ._10000_14999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 14,828kb
// 136ms

public class Main_13549_숨바꼭질_3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static class Point implements Comparable<Point> {
		int x, time;

		Point(int x, int time) {
			this.x = x;
			this.time = time;
		}

		@Override
		public int compareTo(Point o) {
			return this.time - o.time;
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 수빈이가 갈 수 있는 범위 (이 밖은 알 필요 없다.)
		// S : 최소는 작은 값의 반
		// E : 최대는 큰 값의 두 배
		int S = N < K ? N / 2 : K / 2;
		int E = N > K ? N * 2 : K * 2;
		E = E > 100000 ? 100000 : E;

		int min = Integer.MAX_VALUE;
		boolean[] map = new boolean[E + 1];

		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(N, 0));

		while (!pq.isEmpty()) {
			Point point = pq.poll();
			map[point.x] = true;
//			System.out.println(point.x + " " + point.time);
			if (point.x == K) {
				min = point.time;
				break;
			}
			if (point.x * 2 <= E && !map[point.x * 2]) {
				pq.add(new Point(point.x * 2, point.time));
			}
			if (point.x + 1 <= E && !map[point.x + 1]) {
				pq.add(new Point(point.x + 1, point.time + 1));
			}
			if (point.x - 1 >= S && !map[point.x - 1]) {
				pq.add(new Point(point.x - 1, point.time + 1));
			}
		}

		bw.write(min + "");
		bw.flush();
		bw.close();

	}
}