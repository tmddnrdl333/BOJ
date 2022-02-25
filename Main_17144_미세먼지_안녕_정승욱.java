package algorithm_ws.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 23,480kb
// 228ms

public class Main_17144_미세먼지_안녕_정승욱 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int R, C;
	static int[][] map;
	static int[][] spreadMap;
	static int purifier;
	static int res;

	static int[] dr = { -1, 0, 1, 0 }; // 상 우 하 좌
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 끝

		for (int i = 0; i < R; i++) {
			if (map[i][0] == -1) {
				purifier = i;
				break;
			}
		}

		while (T-- != 0) {
			spread();
			circulate();
		}
		sum();
		bw.write(Integer.toString(res));
		bw.flush();
		bw.close();

	}

	public static void spread() {
		spreadMap = new int[R][C]; // 확산시킬 정보를 저장
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 4) { // -1과 0은 아니어야하고, 4여도 /5하면 어차피 안됨.
					// 확산 가능
					int amount = map[i][j]; // 확산 전 미세먼지 양
					for (int dir = 0; dir < 4; dir++) {
						int r = i + dr[dir];
						int c = j + dc[dir];
						if (r == -1 || c == -1 || r == R || c == C || map[r][c] == -1)
							continue;
						spreadMap[i][j] -= amount / 5; // 뺄 것
						spreadMap[r][c] += amount / 5; // 더할 것
					}
				}
			}
		}
		// 확산시킬 정보를 적용
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++) {
				map[i][j] += spreadMap[i][j];
			}
	}

	public static void circulate() {
		// 위 사이클
		int dir = 0;
		int r = purifier - 1;
		int c = 0;
		while (r != purifier || c != 1) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (nr == -1 || nr == purifier + 1 || nc == C) {
				nr = r + dr[++dir];
				nc = c + dc[dir];
			}
			map[r][c] = map[nr][nc];
			r = nr;
			c = nc;
		}
		map[r][c] = 0;
		// 아래 사이클
		dir = 2;
		r = purifier + 2;
		c = 0;
		while (r != purifier + 1 || c != 1) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (nr == purifier || nr == R || nc == C) {
				dir = (dir + 3) % 4;
				nr = r + dr[dir];
				nc = c + dc[dir];
			}
			map[r][c] = map[nr][nc];
			r = nr;
			c = nc;
		}
		map[r][c] = 0;
	}

	public static void sum() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0)
					res += map[i][j];
			}
		}
	}
}
