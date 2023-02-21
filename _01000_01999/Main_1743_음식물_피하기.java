package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 13,664kb
// 120ms

public class Main_1743_음식물_피하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[][] map;

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	static int max = 0;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int cnt = Integer.parseInt(st.nextToken());
		for (; cnt > 0; cnt--) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
			map[r - 1][c - 1] = 1;
		}

		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				BFS(i, j);

		bw.write(max + "");
		bw.flush();
		bw.close();
	}

	static void BFS(int r, int c) {
		if (map[r][c] == 0)
			return;
		Queue<Integer> q = new LinkedList<>();
		int size = 1;
		q.add(r * M + c);
		map[r][c] = 0;

		while (!q.isEmpty()) {
			int idx = q.poll();
			int cr = idx / M, cc = idx % M;
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d], nc = cc + dc[d];
				if (nr == -1 || nc == -1 || nr == N || nc == M)
					continue;
				if (map[nr][nc] == 0)
					continue;
				size++;
				q.add(nr * M + nc);
				map[nr][nc] = 0;
			}
		}

		max = size > max ? size : max;
	}
}