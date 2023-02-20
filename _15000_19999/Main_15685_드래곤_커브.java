package ps.BOJ._15000_19999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,952kb
// 84ms

public class Main_15685_드래곤_커브 {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			map[x][y] = true;
			this.x = x;
			this.y = y;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static boolean[][] map = new boolean[101][101];

	static int N, res;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()); // 방향
			int g = Integer.parseInt(st.nextToken()); // 세대
			mark(x, y, d, g);
		}
		cnt();
		bw.write(Integer.toString(res));
		bw.flush();
		bw.close();
	}

	public static void mark(int x, int y, int d, int g) {
		// g에 따라 점의 개수는
		// 0 - 2, 1 - 3, 2 - 5 ... : 2^g+1개
		Point[] pts = new Point[(1 << g) + 1];

		int nx = x + dx[d];
		int ny = y + dy[d];
		pts[0] = new Point(x, y); // 출발점 x,y
		pts[1] = new Point(nx, ny); // 0세대 연장 점
		for (int gen = 1; gen <= g; gen++) {
			// 기준점은 pts[1<<(현재세대-1)]
			// 그 앞 점들은 기준점 기준 시계방향 90도 회전
			int last = 1 << (gen - 1);
			Point std = pts[last]; // 기준점
			for (int i = 0; i < last; i++) {
				nx = std.x + (std.y - pts[i].y);
				ny = std.y - (std.x - pts[i].x);
				pts[2 * last - i] = new Point(nx, ny);
			}
		}
	}

	public static int cnt() {
		for (int i = 0; i < 100; i++)
			for (int j = 0; j < 100; j++) {
				if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1])
					res++;
			}
		return res;
	}
}