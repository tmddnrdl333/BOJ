package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 12,704kb
// 92ms

public class Main_2583_영역_구하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static class Pnt {
		int r, c;

		Pnt(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int n3 = Integer.parseInt(st.nextToken());
			int n4 = Integer.parseInt(st.nextToken());
			for (int r = n1; r < n3; r++)
				for (int c = n2; c < n4; c++) {
					map[r][c] = 1;
				}
		}

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (map[i][j] != 0)
					continue;

				Queue<Pnt> q = new LinkedList<>();
				int cnt = 0;
				q.add(new Pnt(i, j));
				map[i][j] = 2;

				while (!q.isEmpty()) {
					Pnt cp = q.poll();
					cnt++;
					for (int d = 0; d < 4; d++) {
						int nr = cp.r + dr[d], nc = cp.c + dc[d];
						if (nr == -1 || nc == -1 || nr == N || nc == M)
							continue;
						if (map[nr][nc] != 0)
							continue;
						q.add(new Pnt(nr, nc));
						map[nr][nc] = 2;
					}
				}

				list.add(cnt);

			}
		}

		sb.append(list.size() + "\n");
		Collections.sort(list);
		for (int el : list)
			sb.append(el + " ");

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}