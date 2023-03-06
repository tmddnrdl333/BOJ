package ps.BOJ._15000_19999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 12,768kb
// 96ms

public class Main_16948_데스_나이트 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[][] map;

	static int[] dr = { -2, -2, 0, 0, 2, 2 };
	static int[] dc = { -1, 1, -2, 2, -1, 1 };

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		st = new StringTokenizer(br.readLine());
		boolean isMovable = false;
		int cnt = 0;
		Queue<Integer> q = new LinkedList<>();
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		map[r1][c1] = 1;
		q.add(r1 * N + c1);
		map[r2][c2] = -1;
		outer: while (!q.isEmpty()) {
			int qSize = q.size();
			cnt++;
			for (; qSize > 0; qSize--) {
				int cIdx = q.poll();
				int cr = cIdx / N, cc = cIdx % N;
				for (int d = 0; d < 6; d++) {
					int nr = cr + dr[d], nc = cc + dc[d];
					if (nr >= N || nc >= N || nr <= -1 || nc <= -1)
						continue;
					if (map[nr][nc] == 1)
						continue;
					if (map[nr][nc] == -1) {
						isMovable = true;
						break outer;
					}
					map[nr][nc] = 1;
					q.add(nr * N + nc);
				}
			}
		}
		if (isMovable)
			bw.write(cnt + "");
		else
			bw.write("-1");
		bw.flush();
		bw.close();
	}
}