package ps.BOJ._10000_14999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 21,228kb
// 236ms

public class Main_14716_현수막 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[][] map;
	static int cnt;
	static int[] di = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dj = { -1, 0, 1, 1, 1, 0, -1, -1 };

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
				if (map[i][j] == 1)
					BFS(i, j);

		bw.write(cnt + "");
		bw.flush();
		bw.close();

	}

	static void BFS(int i, int j) {
		Queue<Integer> q = new LinkedList<>();
		cnt++;
		map[i][j] = 0;
		q.add(i * M + j);

		while (!q.isEmpty()) {
			int idx = q.poll();
			int ii = idx / M, jj = idx % M;
			for (int d = 0; d < 8; d++) {
				int ni = ii + di[d], nj = jj + dj[d];
				if (ni == -1 || nj == -1 || ni == N || nj == M)
					continue;
				if (map[ni][nj] == 0)
					continue;
				map[ni][nj] = 0;
				q.add(ni * M + nj);
			}
		}

	}
}