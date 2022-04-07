package ps_BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 39,480kb
// 328ms

public class Main_1520_내리막길 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, M;
	static int[][] map;
	static int[][] dp;

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(dp[i], -1);
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		dp[N - 1][M - 1] = 1;
		DFS(0, 0);
		bw.write(Integer.toString(dp[0][0]));
		bw.flush();
		bw.close();
	}

	static int DFS(int r, int c) {

		if (r == N - 1 && c == M - 1)
			return 1;
		if (dp[r][c] != -1)
			return dp[r][c];

		dp[r][c] = 0;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr == -1 || nc == -1 || nr == N || nc == M)
				continue;
			if (map[nr][nc] >= map[r][c])
				continue;
			dp[r][c] += DFS(nr, nc);
		}
		return dp[r][c];
	}
}