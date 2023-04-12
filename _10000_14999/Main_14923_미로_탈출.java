package ps.BOJ._10000_14999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 93,556kb
// 604ms

public class Main_14923_미로_탈출 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[][] map;
	static boolean[][] mtv; // magic true visit;
	static boolean[][] mfv; // magic false visit;

	static int Hx, Hy, Ex, Ey;

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	static class Point {
		int r, c;
		boolean magic;

		Point(int r, int c, boolean magic) {
			this.r = r;
			this.c = c;
			this.magic = magic;
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		mtv = new boolean[N + 1][M + 1];
		mfv = new boolean[N + 1][M + 1];
		st = new StringTokenizer(br.readLine());
		Hx = Integer.parseInt(st.nextToken());
		Hy = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Ex = Integer.parseInt(st.nextToken());
		Ey = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		Queue<Point> q = new LinkedList<>();
		q.add(new Point(Hx, Hy, true));
		mtv[Hx][Hy] = true;
		mfv[Hx][Hy] = true;

		int dis = 0;

		outer: while (true) {
			dis++;
			int qSize = q.size();
			if (qSize == 0) {
				dis = -1;
				break;
			}
			for (; qSize > 0; qSize--) {
				Point cp = q.poll();
				for (int d = 0; d < 4; d++) {
					int nr = cp.r + dr[d], nc = cp.c + dc[d];
					if (nr == 0 || nr == N + 1 || nc == 0 || nc == M + 1)
						continue;

					// 도착 -> 탈출
					if (nr == Ex && nc == Ey)
						break outer;

					// 사용 가능
					if (cp.magic) {

						// 가능인채로 방문한적 있으면 패스 (불가능인채로 방문한적있는건 상관없음)
						if (mtv[nr][nc])
							continue;
						// 벽이라면 뚫고
						if (map[nr][nc] == 1) {
							q.add(new Point(nr, nc, false));
							mtv[nr][nc] = true;
							mfv[nr][nc] = true;
						}
						// 아니라면 그냥 가기
						else {
							q.add(new Point(nr, nc, true));
							mtv[nr][nc] = true;
							mfv[nr][nc] = true;
						}

					}
					// 사용 불가능
					else {

						// 어떤 형태로든 방문한적 있으면 패스
						if (mtv[nr][nc] || mfv[nr][nc])
							continue;
						// 벽이면 패스
						if (map[nr][nc] == 1)
							continue;
						else {
							q.add(new Point(nr, nc, false));
							mfv[nr][nc] = true;
						}

					}
				}
			}
		}

		bw.write(dis + "");
		bw.flush();
		bw.close();

	}
}