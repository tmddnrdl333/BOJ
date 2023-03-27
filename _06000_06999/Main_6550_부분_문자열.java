package ps.BOJ._06000_06999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 49,800kb
// 188ms

public class Main_6550_부분_문자열 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int R, C;
	static char[][] map;
	static int oCnt, vCnt;

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String inp = br.readLine();
			for (int j = 0; j < C; j++)
				map[i] = inp.toCharArray();
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '#' || map[i][j] == '/')
					continue;
				exec(i, j);
			}
		}

		bw.write(oCnt + " " + vCnt);
		bw.flush();
		bw.close();
	}

	static void exec(int i, int j) {
		int o = 0, v = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(i * C + j);
		if (map[i][j] == 'o')
			o++;
		else if (map[i][j] == 'v')
			v++;
		map[i][j] = '/';

		while (!q.isEmpty()) {
			int idx = q.poll();
			int ci = idx / C, cj = idx % C;
			for (int d = 0; d < 4; d++) {
				int ni = ci + dr[d], nj = cj + dc[d];
				if (ni == R || ni == -1 || nj == C || nj == -1)
					return;
				if (map[ni][nj] == '#' || map[ni][nj] == '/')
					continue;
				q.add(ni * C + nj);
				if (map[ni][nj] == 'o')
					o++;
				else if (map[ni][nj] == 'v')
					v++;
				map[ni][nj] = '/';
			}
		}

		if (o > v)
			oCnt += o;
		else
			vCnt += v;

	}
}