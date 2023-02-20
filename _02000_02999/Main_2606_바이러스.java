package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 11,808kb
// 84ms

public class Main_2606_바이러스 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		boolean[][] adjM = new boolean[N][N];
		boolean[] visited = new boolean[N];
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			adjM[from][to] = true;
			adjM[to][from] = true;
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		visited[0] = true;
		int cnt = -1;
		while (!q.isEmpty()) {
			cnt++;
			int cur = q.poll();
			for (int i = 0; i < N; i++) {
				if (!visited[i] && adjM[cur][i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		bw.write(Integer.toString(cnt));
		bw.flush();
		bw.close();
	}
}