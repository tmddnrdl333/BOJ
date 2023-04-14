package ps.BOJ._05000_05999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 52,972kb
// 200ms

public class Main_5014_스타트링크 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		boolean[] visited = new boolean[F + 1];

		Queue<Integer> q = new LinkedList<>();
		q.add(S);
		visited[S] = true;

		int res = -1;
		int cnt = 0;

		outer: while (!q.isEmpty()) {
			int qSize = q.size();
			for (; qSize > 0; qSize--) {
				int cur = q.poll();

				if (cur == G) {
					res = cnt;
					break outer;
				}

				if (cur + U <= F && !visited[cur + U]) {
					q.add(cur + U);
					visited[cur + U] = true;
				}
				if (cur - D >= 1 && !visited[cur - D]) {
					q.add(cur - D);
					visited[cur - D] = true;
				}
			}
			cnt++;
		}

		if (res == -1)
			bw.write("use the stairs");
		else
			bw.write(res + "");
		bw.flush();
		bw.close();
	}
}