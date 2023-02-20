package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 12,376kb
// 100ms

public class Main_2178_미로_탐색 {
	static class P {
		int r, c;

		P(int r, int c) {
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

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++)
				map[i][j] = temp[j] - '0';
		}

		// BFS
		Queue<P> q = new LinkedList<>();
		map[0][0] = 2;
		q.add(new P(0, 0));
		int cnt = 1;
		w: while (!q.isEmpty()) {
			cnt++;
			int size = q.size();
			for (; size != 0; size--) {
				P cp = q.poll();
				for (int dir = 0; dir < 4; dir++) {
					int nr = cp.r + dr[dir];
					int nc = cp.c + dc[dir];
					if (nr == -1 || nc == -1 || nr == N || nc == M)
						continue;
					if (nr == N - 1 && nc == M - 1)
						break w;
					if (map[nr][nc] == 1) {
						map[nr][nc] = 2;
						q.add(new P(nr, nc));
					}
				}
			}
		}
		bw.write(Integer.toString(cnt));
		bw.flush();
		bw.close();

	}
}