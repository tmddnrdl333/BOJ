package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 12,228kb
// 108ms

public class Main_1189_컴백홈 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int R, C, K;
	static char[][] map;
	static int res;

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		map[R - 1][0] = 'x';
		dfs(R - 1, 0, 1);

		bw.write(res + "");
		bw.flush();
		bw.close();

	}

	static void dfs(int r, int c, int k) {
		if (k == K) {
			if (r == 0 && c == C - 1)
				res++;
			return;
		}
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d], nc = c + dc[d];
			if (nr == R || nc == C || nr == -1 || nc == -1)
				continue;
			if (map[nr][nc] != '.')
				continue;

			map[nr][nc] = 'x';
			dfs(nr, nc, k + 1);
			map[nr][nc] = '.';
		}
	}

}