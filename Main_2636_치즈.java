package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 13,976kb
// 128ms

public class Main_2636_치즈 {
	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;

	static int R, C;
	static int[][] map;

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		int cheeseCnt = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int cur = Integer.parseInt(st.nextToken());
				map[i][j] = cur;
				if (cur == 1)
					cheeseCnt++;
			}
		}

		int time = 0;
		int lastCnt = 0;
		Queue<Point> airQ = new LinkedList<>();
		while (cheeseCnt != 0) {
			time++;
			lastCnt = cheeseCnt;
			map[0][0] = -1;
			airQ.add(new Point(0, 0));
			while (!airQ.isEmpty()) {
				Point cur = airQ.poll();
				for (int dir = 0; dir < 4; dir++) {
					int nr = cur.r + dr[dir];
					int nc = cur.c + dc[dir];
					if (nr == -1 || nc == -1 || nr == R || nc == C)
						continue;
					if (map[nr][nc] == 0) {
						map[nr][nc] = -1;
						airQ.add(new Point(nr, nc));
					} else if (map[nr][nc] == 1) {
						map[nr][nc] = 2;
						cheeseCnt--;
					}
				}
			}
			for (int i = 0; i < R; i++)
				for (int j = 0; j < C; j++)
					if (map[i][j] == -1 || map[i][j] == 2)
						map[i][j] = 0;
		}
		bw.write(time + "\n" + lastCnt);
		bw.flush();
		bw.close();
	}
}