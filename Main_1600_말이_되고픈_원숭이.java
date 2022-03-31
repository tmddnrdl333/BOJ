package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 73,288kb
// 376ms

public class Main_1600_말이_되고픈_원숭이 {

	static class Point {
		int r, c, k;

		public Point(int r, int c, int k) {
			this.r = r;
			this.c = c;
			this.k = k;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	static int[] drh = { 2, 2, 1, 1, -1, -1, -2, -2 };
	static int[] dch = { 1, -1, 2, -2, 2, -2, 1, -1 };

	public static void main(String[] args) throws IOException {

		int K = Integer.parseInt(br.readLine()) + 1;
		st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][] map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = -Integer.parseInt(st.nextToken());
			}
		}

		// BFS
		boolean flag = false;
		int time = 0;
		Queue<Point> q = new LinkedList<>();
		map[0][0] = K;
		q.add(new Point(0, 0, K));
		w: while (!q.isEmpty()) {
			int size = q.size();
			for (; size != 0; size--) {
				Point cur = q.poll();
				if (cur.r == H - 1 && cur.c == W - 1) {
					flag = true;
					break w;
				}
				if (cur.k != 1) {
					for (int dir = 0; dir < 8; dir++) {
						int nr = cur.r + drh[dir];
						int nc = cur.c + dch[dir];
						if (nr < 0 || nc < 0 || nr >= H || nc >= W)
							continue;
						if (map[nr][nc] == -1)
							continue;
						if (map[nr][nc] >= cur.k - 1)
							continue;
						map[nr][nc] = cur.k - 1;
						q.add(new Point(nr, nc, cur.k - 1));
					}
				}
				for (int dir = 0; dir < 4; dir++) {
					int nr = cur.r + dr[dir];
					int nc = cur.c + dc[dir];
					if (nr < 0 || nc < 0 || nr >= H || nc >= W)
						continue;
					if (map[nr][nc] == -1)
						continue;
					if (map[nr][nc] >= cur.k)
						continue;
					map[nr][nc] = cur.k;
					q.add(new Point(nr, nc, cur.k));
				}
			}
			time++;
		}
		if (!flag)
			time = -1;
		bw.write(Integer.toString(time));
		bw.flush();
		bw.close();

	}

}