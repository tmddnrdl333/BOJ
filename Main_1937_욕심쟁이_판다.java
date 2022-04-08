package ps_BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 56,212kb
// 856ms

public class Main_1937_욕심쟁이_판다 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;

	static int N;
	static int[][] map;
	static int[][] dp;
	static PriorityQueue<int[]> pq;

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N];

		pq = new PriorityQueue<>((o1, o2) -> (o2[2] - o1[2]));

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int cur = Integer.parseInt(st.nextToken());
				map[i][j] = cur;
				pq.offer(new int[] { i, j, cur });
			}
			Arrays.fill(dp[i], -1);
		}

		int max = 0;

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();

			int time = DFS(cur[0], cur[1]);
			max = time > max ? time : max;
		}
		bw.write(Integer.toString(max));
		bw.flush();
		bw.close();

	}

	public static int DFS(int r, int c) {

		if (dp[r][c] != -1)
			return dp[r][c];

		dp[r][c] = 0;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr == -1 || nc == -1 || nr == N || nc == N)
				continue;
			if (map[nr][nc] <= map[r][c])
				continue;
			dp[r][c] = Math.max(dp[r][c], DFS(nr, nc) + 1);
		}

		dp[r][c] = Math.max(dp[r][c], 1);
		return dp[r][c];

	}
}