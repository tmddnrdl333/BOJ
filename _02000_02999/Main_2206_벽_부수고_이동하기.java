package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 119,240kb
// 628ms

public class Main_2206_벽_부수고_이동하기 {

	static class Point {
		int r, c;
		boolean broke; // 내가 벽을 뚫은 적 있는지

		Point(int r, int c, boolean broke) {
			this.r = r;
			this.c = c;
			this.broke = broke;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;

	// map의 값
	// 000 (2)
	// 일의 자리 : 벽이 있다 1 없다 0
	// 십의 자리 : 안 뚫고 지나온 곳이다 1 안 뚫고 안 지났다 0
	// 백의 자리 : 뚫고 지나온 곳이다 1 뚫고 안지나왔다 0
	// 가능한 경우 :
	// 000(벽없고 간적없음) 001(벽있고 간적없음)
	// 010(벽없고 간적있음) 100(벽없고 뚫고 간적있음)
	// 101(벽있고 뚫고 간적있음) 110(벽없고 뚫고 간적있고 안뚫고 간적있음)
	// 불가능한 경우 :
	// 011(벽이있는데 안뚫고 간적있음 x)
	// 111(상동)
	static int[][] map;
	static int resTime;
	static Queue<Point> q = new LinkedList<>();

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		bfs();
		bw.write(Integer.toString(resTime));
		bw.flush();
		bw.close();
	}

	public static void bfs() {

		int time = 0;
		boolean success = false;

		q.add(new Point(0, 0, false));
		map[0][0] = 2; // 10 : 벽이 아니면서, 안뚫고 지나온 곳이라는 표기
		w: while (!q.isEmpty()) {
			int qs = q.size();
			time++;
			for (; qs != 0; qs--) {
				Point p = q.poll();
				if (p.r == N - 1 && p.c == M - 1) {
					success = true;
					break w;
				}
				// 01. 안 뚫어본 경우
				// - 내가 왔던 곳은 안감 (뚫고 갔던 곳은 괜찮)
				// - 대신 벽이 있으면 뚫고 기록하고 가고, 없으면 그냥 감
				if (!p.broke) {
					// 4 방향에 대하여
					for (int dir = 0; dir < 4; dir++) {
						int nr = p.r + dr[dir];
						int nc = p.c + dc[dir];
						// 장외는 안감
						if (nr == -1 || nc == -1 || nr == N || nc == M)
							continue;

						int np = map[nr][nc]; // 다음 후보

						// 내가 왔던 곳은 안 감 (뚫고 갔던 곳은 괜찮)
						if ((np & 1 << 1) != 0) {
							continue;
						}
						// 벽을 만나면 뚫고 기록하고 지나감
						if ((np & 1 << 0) != 0) {
							map[nr][nc] |= 1 << 2; // 뚫고 지나온 표시
							q.add(new Point(nr, nc, true));
						}
						// 벽이 아니면 그냥 감
						if ((np & 1 << 0) == 0) {
							map[nr][nc] |= 1 << 1; // 안 뚫고 지나온 표시
							q.add(new Point(nr, nc, false));
						}
					}
					// 02. 뚫어본 경우
					// - 벽이면 못감
					// - 누군가 왔던 곳은 안감 (뚫고 갔든 안 뚫고 갔든 안감)
					// - 그 외 감
				} else {
					// 4 방향에 대하여
					for (int dir = 0; dir < 4; dir++) {
						int nr = p.r + dr[dir];
						int nc = p.c + dc[dir];
						// 장외는 안감
						if (nr == -1 || nc == -1 || nr == N || nc == M)
							continue;

						int np = map[nr][nc];

						// 벽이면 못감
						if ((np & 1 << 0) != 0) {
							continue;
						}
						// 누군가 왔던 곳은 안감
						if ((np & 1 << 1) != 0 || (np & 1 << 2) != 0) {
							continue;
						}
						map[nr][nc] |= 1 << 2; // 뚫고 지나온 표시
						q.add(new Point(nr, nc, true));
					}

				}
			} // for qs
		}
		if (success)
			resTime = time;
		else
			resTime = -1;
	}
}
