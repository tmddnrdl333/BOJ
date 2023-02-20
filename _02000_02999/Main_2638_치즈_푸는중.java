package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 22% 메모리초과

public class Main_2638_치즈_푸는중 {

	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;

	static int N, M;
	static int[][] map; // -2 공기 -1 확인 중 0 미정 1 치즈 2 진공
	static int cheese = 0;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static Queue<Point> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int cur = Integer.parseInt(st.nextToken());
				if (cur == 1)
					cheese++;
				map[i][j] = cur;
			}
		}
		int time = 0;
		while (cheese > 0) {
			time++;
			buildmap();

			test();

			for (int i = 0; i < N; i++)
				for (int j = 0; j < M; j++)
					if (map[i][j] == 1)
						check(i, j);
					else if (map[i][j] == 2) // 진공이 다음에도 진공인지 모르니까
						map[i][j] = 0;
		}
		bw.write(Integer.toString(time));
		bw.flush();
		bw.close();
	}

	public static void test() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.printf("%3d", map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	// 0(미정)이면 BFS시행
	public static void buildmap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					BFS(i, j);
			}
		}
	}

	// 동일 영역의 모든 0을 다 2나 -2중 알맞는 값으로 바꿔줌
	public static void BFS(int i, int j) {
		q.clear();
		boolean isVac = true; // true : 둘러싸임, false : 공기 접촉
		map[i][j] = -1;
		q.add(new Point(i, j));
		while (!q.isEmpty()) {
			Point cur = q.poll();
			map[cur.r][cur.c] = -1;
			if (cur.r == 0 || cur.c == 0 || cur.r == N || cur.c == M)
				isVac = false;
			for (int dir = 0; dir < 4; dir++) {
				int di = cur.r + dr[dir];
				int dj = cur.c + dc[dir];
				if (di == -1 || dj == -1 || di == N || dj == M)
					continue;
				if (map[di][dj] == -2) {
					isVac = false;
					map[cur.r][cur.c] = -2;
				}
				if (map[di][dj] != 0)
					continue;
				q.add(new Point(di, dj));
			}
		}
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == -1) {
					map[r][c] = isVac ? 2 : -2;
				}
			}
		}
	}

	public static void check(int i, int j) {
		int cnt = 0;
		for (int dir = 0; dir < 4; dir++) {
			int di = i + dr[dir];
			int dj = j + dc[dir];
			if (di == -1 || dj == -1 || di == N || dj == M) {
				cnt++;
				continue;
			}
			if (map[di][dj] == -2)
				cnt++;
		}
		if (cnt >= 2) {
			map[i][j] = 0;
			cheese--;
		}
	}
}