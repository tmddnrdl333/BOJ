package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 13,860kb
// 116ms

public class Main_1245_농장_관리 {

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
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[][] map;
	static int[][] checked; // 0-unchecked, 1-false, 2-true

	static Queue<Point> q = new LinkedList<>();
	static List<Point> list = new ArrayList<>();

	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 위부터 시계방향
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	static int topCnt = 0;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		checked = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (checked[i][j] == 0)
					check(i, j);

		bw.write(Integer.toString(topCnt));
		bw.flush();
		bw.close();
	}

	// 값들을 q와 list에 넣으면서 bfs탐색.
	// q는 빼면서 탐색하지만 list는 넣기만 하다가
	// q가 비게 될 때 결과를 list에 있는 Point들에 저장
	public static void check(int r, int c) {
		int standard = map[r][c]; // 비교 기준이 될 점
		q.add(new Point(r, c)); // bfs에서 꺼낼 점
		list.add(new Point(r, c)); // 다 끝나고 바꿀 점들
		checked[r][c] = 1; // 방문체크
		boolean isTop = true; // 바꿀 값을 알려주는 불리언
		// bfs
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int dir = 0; dir < 8; dir++) {
				int nr = p.r + dr[dir];
				int nc = p.c + dc[dir];
				if (nr == -1 || nc == -1 || nr == N || nc == M)
					continue;
				int cur = map[nr][nc];
				// 같을 때
				if (cur == standard && checked[nr][nc] == 0) {
					q.add(new Point(nr, nc));
					list.add(new Point(nr, nc));
					checked[nr][nc] = 1;
				} else if (cur > standard) {
					isTop = false;
					continue;
				}
			}
		}
		// 산봉우리가 맞다면 2가 됨
		if (isTop) {
			topCnt++;
			for (Point p : list)
				checked[p.r][p.c]++;
		}
		list.clear();
	}
}