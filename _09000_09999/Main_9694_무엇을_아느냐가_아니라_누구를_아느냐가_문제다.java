package ps.BOJ._09000_09999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

// 39,968kb
// 352ms

public class Main_9694_무엇을_아느냐가_아니라_누구를_아느냐가_문제다 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static class V implements Comparable<V> {
		int no, w;

		V(int no, int w) {
			this.no = no;
			this.w = w;
		}

		public int compareTo(V o) {
			return this.w - o.w;
		}
	}

	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			List<List<V>> list = new ArrayList<>();
			for (int i = 0; i < M; i++)
				list.add(new ArrayList<>());

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				list.get(a).add(new V(b, w));
				list.get(b).add(new V(a, w));
			}

			int[] dis = new int[M];
			int[] route = new int[M];
			boolean[] v = new boolean[M];

			Arrays.fill(dis, Integer.MAX_VALUE);
			Arrays.fill(route, -1);

			dis[0] = 0;

			PriorityQueue<V> pq = new PriorityQueue<>();
			pq.add(new V(0, 0));

			while (!pq.isEmpty()) {
				int cur = pq.poll().no;

				if (v[cur])
					continue;
				v[cur] = true;

				if (cur == M - 1)
					break;

				for (V vertex : list.get(cur)) {
					if (dis[vertex.no] > dis[cur] + vertex.w) {
						dis[vertex.no] = dis[cur] + vertex.w;
						route[vertex.no] = cur;
						pq.add(new V(vertex.no, dis[vertex.no]));
					}
				}
			}

			Stack<Integer> stack = new Stack<>();
			int p = M - 1;
			while (p != -1) {
				stack.add(p);
				p = route[p];
			}

			sb.append("Case #" + tc + ": ");
			if (stack.size() == 1) {
				sb.append("-1");
			} else {
				while (!stack.isEmpty()) {
					sb.append(stack.pop()).append(" ");
				}
//				sb.setLength(sb.length() - 1);
			}
			sb.append("\n");

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}