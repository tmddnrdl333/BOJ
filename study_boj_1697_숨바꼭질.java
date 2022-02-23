package study.day0221;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 16,484kb
// 112ms

public class study_boj_1697_숨바꼭질 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, K, res;
	static Queue<int[]> q = new LinkedList<>();
	static boolean[] visited = new boolean[100001];

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		go5();
		bw.write(Integer.toString(res));
		bw.flush();
		bw.close();

	}

	public static void go5() {
		visited[N] = true;
		q.add(new int[] { N, 0 });
		while (true) {
			int t1 = q.peek()[0];
			int t2 = q.poll()[1];
			if (t1 == K) {
				res = t2;
				break;
			}
			if (t1 - 1 != -1 && !visited[t1 - 1]) {
				visited[t1 - 1] = true;
				q.add(new int[] { t1 - 1, t2 + 1 });
			}
			if (t1 + 1 < 100001 && !visited[t1 + 1]) {
				visited[t1 + 1] = true;
				q.add(new int[] { t1 + 1, t2 + 1 });

			}
			if (2 * t1 < 100001 && !visited[2 * t1]) {
				visited[2 * t1] = true;
				q.add(new int[] { 2 * t1, t2 + 1 });
			}
		}

	}
}