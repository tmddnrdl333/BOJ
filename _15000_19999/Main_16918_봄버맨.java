package ps.BOJ._15000_19999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 107,880kb
// 300ms

public class Main_16918_봄버맨 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int R, C, N;
	static int[][] map;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 }; // 상 우 하 좌

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				char cur = str.charAt(j);
				if (cur == 'O')
					map[i][j] = 2;
			}
		}

		for (int i = 0; i < N - 1; i++) {
			action();
		}
		makesb();

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	public static void action() {
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 3;
				} else {
					map[i][j]--;
					if (map[i][j] == 0)
						q.add(new int[] { i, j });
				}
			}
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nr = cur[0] + dr[dir];
				int nc = cur[1] + dc[dir];
				if (nr == -1 || nc == -1 || nr == R || nc == C)
					continue;
				map[nr][nc] = 0;
			}
		}
	}

	public static void makesb() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++)
				if (map[i][j] == 0)
					sb.append(".");
				else
					sb.append("O");
			sb.append("\n");
		}
	}
}