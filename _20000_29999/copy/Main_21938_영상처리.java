package ps.BOJ._20000_29999.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 131012kb
// 644ms

public class Main_21938_영상처리 {
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, M;
	static int[][] arr;
	static int T;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()),
						c = Integer.parseInt(st.nextToken());
				arr[i][j] = a + b + c;
			}
		}

		T = Integer.parseInt(br.readLine()) * 3;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (isObject(i, j)) {
					cnt++;
					BFS(i, j);
				}
			}
		}
		bw.write(cnt + "");
		bw.flush();
		bw.close();
	}

	static boolean isObject(int r, int c) {
		boolean ret = arr[r][c] >= T;
		arr[r][c] = -1;
		return ret;
	}

	static void BFS(int r, int c) {
		Queue<Integer> q = new LinkedList<>();
		q.add(r * M + c);
		while (!q.isEmpty()) {
			int cidx = q.poll();
			int cr = cidx / M, cc = cidx % M;
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d], nc = cc + dc[d];
				if (nr == -1 || nr == N || nc == -1 || nc == M)
					continue;
				if (isObject(nr, nc)) {
					q.add(nr * M + nc);
				}
			}
		}
	}
}
