package ps.BOJ._15000_19999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 61,836kb
// 344ms

public class Main_17836_공주님을_구해라 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static class Pnt {
		int r, c;
		boolean sword;

		Pnt(int r, int c, boolean sword) {
			this.r = r;
			this.c = c;
			this.sword = sword;
		}
	}

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		Queue<Pnt> q = new LinkedList<>();
		q.add(new Pnt(0, 0, false));
		map[0][0] = -1;

		int time = 0;
		boolean success = false;

		outer: while (!q.isEmpty()) {
			time++;
			if (time > T)
				break;
			int qSize = q.size();
			for (; qSize > 0; qSize--) {
				Pnt cp = q.poll();
				for (int d = 0; d < 4; d++) {
					int nr = cp.r + dr[d];
					int nc = cp.c + dc[d];

					if (nr == N - 1 && nc == M - 1) {
						// FIN
						success = true;
						break outer;
					}

					// 장외
					if (nr == -1 || nc == -1 || nr == N || nc == M)
						continue;
					// 02. 칼 없는데 벽
					if (!cp.sword && map[nr][nc] == 1)
						continue;
					// 03. 이미 온 곳
					if (!cp.sword && map[nr][nc] == -1 || cp.sword && map[nr][nc] == -2)
						continue;
					// 가능
					if (map[nr][nc] == 2) {
						q.add(new Pnt(nr, nc, true));
						map[nr][nc] = -2;
					} else {
						q.add(new Pnt(nr, nc, cp.sword));
						map[nr][nc] = cp.sword ? -2 : -1;
					}
				}
			}
		}

		if (success)
			bw.write(time + "");
		else
			bw.write("Fail");
		bw.flush();
		bw.close();

	}
}