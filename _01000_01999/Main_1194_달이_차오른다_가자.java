package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 14,136kb
// 100ms

public class Main_1194_달이_차오른다_가자 {

	static class Point {
		int r, c, state;

		public Point(int r, int c, int state) {
			this.r = r;
			this.c = c;
			this.state = state;
		}
	}

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;

	static int N, M, time;
	static int[][] map;
	static boolean[][][] visit;
	static Point start;
	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M][1 << 6]; // 6개 열쇠, 2^6=64개의 상태 (0은 아무 열쇠도 없는 상태, 63은 모든 열쇠 다 있는 상태)
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				char cur = str.charAt(j);
				if (cur == '.') {// 빈칸
				} else if (cur == '#') {// 벽
					map[i][j] = -5;
				} else if (cur >= 'a' && cur <= 'f') { // 열쇠
					map[i][j] = cur - 'a' + 1;
				} else if (cur >= 'A' && cur <= 'F') {// 문
					map[i][j] = cur - 'A' + 11;
				} else if (cur == '0') { // 출발점
					start = new Point(i, j, 0);
				} else if (cur == '1') {// 도착점
					map[i][j] = -9;
				}
			}
		}

		// 시작
		BFS();

		if (!flag)
			time = -1;
		bw.write(Integer.toString(time));
		bw.flush();
		bw.close();
	}

	public static void BFS() {
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		visit[start.r][start.c][0] = true;
		// BFS ~
		w: while (!q.isEmpty()) {
			time++;
			int size = q.size();
			// 같은 time 이동 ~
			for (; size != 0; size--) {
				Point cur = q.poll();
				int cs = cur.state;

				// 4방 탐색 ~
				for (int dir = 0; dir < 4; dir++) {
					int nr = cur.r + dr[dir];
					int nc = cur.c + dc[dir];

					if (nr == -1 || nc == -1 || nr == N || nc == M) // 장외
						continue;
					if (visit[nr][nc][cs]) // 이 상태로 이미 방문
						continue;

					// 이동 ~
					if (map[nr][nc] == -5) { // 벽
						continue;
					} else if (map[nr][nc] == 0) { // 길
						visit[nr][nc][cs] = true;
						q.add(new Point(nr, nc, cs));
					} else if (map[nr][nc] == -9) { // 도착했으면 나가기
						flag = true;
						break w;
					} else if (map[nr][nc] >= 1 && map[nr][nc] <= 6) { // 열쇠면
						int key = map[nr][nc] - 1;
						int ns = cs | 1 << key;
						visit[nr][nc][ns] = true;
						q.add(new Point(nr, nc, ns));
					} else { // 문이면 열 수 있으면 들어가기
						int door = map[nr][nc] - 11;
						if ((cs & 1 << door) != 0) {
							visit[nr][nc][cs] = true;
							q.add(new Point(nr, nc, cs));
						}
					}
					// ~ 이동
				}
				// ~ 4방 탐색

			}
			// ~ 같은 time 이동

		}
		// ~BFS
	}
}