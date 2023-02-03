package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 146,248kb
// 428ms

public class Main_17086_아기_상어_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static int res;

	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				BFS(i, j);

		bw.write(res + "");
		bw.flush();
		bw.close();
	}

	static void BFS(int i, int j) {
		// 아기 상어의 위치인 경우
		if (map[i][j] == 1) {
			return;
		}
		// 아기 상어의 위치가 아닌 경우 BFS 시행
		int distance = 0;
		visit = new boolean[N][M];
		Queue<Integer> q = new LinkedList<>();
		visit[i][j] = true;
		q.add(i * M + j);
		while (!q.isEmpty()) {
			distance++;
			int size = q.size();
			for (int s = 0; s < size; s++) {
				int idx = q.poll();
				int r = idx / M, c = idx % M;
				for (int d = 0; d < 8; d++) {
					int nr = r + dr[d], nc = c + dc[d];
					if (nr == -1 || nc == -1 || nr == N || nc == M)
						continue;
					if (visit[nr][nc])
						continue;
					if (map[nr][nc] == 0) {
						visit[nr][nc] = true;
						q.add(nr * M + nc);
					} else if (map[nr][nc] == 1) {
						res = distance > res ? distance : res;
						return;
					}
				}
			}
		}
	}
}