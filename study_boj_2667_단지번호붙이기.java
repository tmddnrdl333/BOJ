package study.day0222;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 11,792kb
// 84ms

public class study_boj_2667_단지번호붙이기 {

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[][] map;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		int cnt = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					cnt++;
					list.add(bfs(new Point(i, j)));
				}
			}
		}

		Integer[] arr = list.toArray(new Integer[list.size()]);
		Arrays.sort(arr);

		// 출력
		bw.write(cnt + "\n");
		for (int a : arr)
			bw.write(a + "\n");
		bw.flush();
		bw.close();

	}

	public static int bfs(Point p) {
		Queue<Point> q = new LinkedList<>();
		map[p.r][p.c] -= 2;
		q.add(p);
		int houseCnt = 1;
		while (!q.isEmpty()) {
			int r = q.peek().r;
			int c = q.poll().c;
			for (int dir = 0; dir < 4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if (nr == -1 || nc == -1 || nr == N || nc == N)
					continue;
				if (map[nr][nc] == 1) {
					map[nr][nc] -= 2;
					q.add(new Point(nr, nc));
					houseCnt++;
				}
			}
		}
		return houseCnt;
	}
}
