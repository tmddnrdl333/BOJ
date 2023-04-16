package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 42,944kb
// 360ms

public class Main_1926_그림 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n, m;
	static int[][] map;

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	static class Pnt {
		int r, c;

		Pnt(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int cnt = 0;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1)
					bfs(i, j);
			}
		}

		bw.write(cnt + "\n" + max);
		bw.flush();
		bw.close();
	}

	static void bfs(int r, int c) {
		cnt++;
		int tcnt = 1;
		Queue<Pnt> q = new LinkedList<>();
		q.add(new Pnt(r, c));
		map[r][c] = 0;

		while (!q.isEmpty()) {
			Pnt cp = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cp.r + dr[d];
				int nc = cp.c + dc[d];
				if (nr >= n || nr < 0 || nc >= m || nc < 0)
					continue;
				if (map[nr][nc] == 0)
					continue;
				q.add(new Pnt(nr, nc));
				map[nr][nc] = 0;
				tcnt++;
			}
		}

		max = tcnt > max ? tcnt : max;
	}
}