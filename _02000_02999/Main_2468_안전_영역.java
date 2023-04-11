package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 47,592kb
// 324ms

public class Main_2468_안전_영역 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[][] map;

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		int min = 100, max = 1;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int inp = Integer.parseInt(st.nextToken());
				map[i][j] = inp;
				min = inp < min ? inp : min;
				max = inp > max ? inp : max;
			}
		}

		int cntMax = 1;
		for (int h = min; h <= max; h++) {
			int cnt = exec(h);
			cntMax = cnt > cntMax ? cnt : cntMax;
		}

		bw.write(cntMax + "");
		bw.flush();
		bw.close();
	}

	static int exec(int h) {
		int cnt = 0;

		boolean[][] v = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (v[i][j])
					continue;
				if (map[i][j] <= h)
					continue;

				cnt++;
				Queue<Integer> q = new LinkedList<>();
				q.add(i * N + j);
				v[i][j] = true;

				while (!q.isEmpty()) {
					int ci = q.poll();
					int cr = ci / N, cc = ci % N;
					for (int d = 0; d < 4; d++) {
						int nr = cr + dr[d], nc = cc + dc[d];
						if (nr == -1 || nr == N || nc == -1 || nc == N)
							continue;
						if (v[nr][nc])
							continue;
						if (map[nr][nc] <= h)
							continue;
						q.add(nr * N + nc);
						v[nr][nc] = true;
					}
				}

			}
		}

		return cnt;
	}
}