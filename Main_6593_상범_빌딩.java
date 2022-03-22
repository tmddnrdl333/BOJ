package study.day0317;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 16,500kb
// 140ms

public class Main_6593_상범_빌딩 {

	static class P {
		int l, r, c;

		P(int l, int r, int c) {
			this.l = l;
			this.r = r;
			this.c = c;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int L, R, C;
	static int[][][] map;
	static Queue<P> q = new LinkedList<>();

	static int[] dl = { 1, 0, 0, -1, 0, 0 };
	static int[] dr = { 0, 1, 0, 0, -1, 0 };
	static int[] dc = { 0, 0, 1, 0, 0, -1 };

	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		while (true) {
			q.clear();
			boolean flag = false;
			st = new StringTokenizer(str);
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if (L == 0 && R == 0 && C == 0)
				break;
			map = new int[L][R][C];
			String temp = null;
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					temp = br.readLine();
					for (int k = 0; k < C; k++) {
						char cur = temp.charAt(k);
						if (cur == '#')
							map[i][j][k] = 1;
						else if (cur == '.')
							map[i][j][k] = 0;
						else if (cur == 'S') {
							map[i][j][k] = 1;
							q.add(new P(i, j, k));
						} else if (cur == 'E') {
							map[i][j][k] = -1;
						}
					}
				}
				temp = br.readLine();
			}
			//
			int cnt = 0;
			w: while (!q.isEmpty()) {
				cnt++;
				int size = q.size();
				for (; size != 0; size--) {
					P cur = q.poll();
					for (int dir = 0; dir < 6; dir++) {
						int nl = cur.l + dl[dir];
						int nr = cur.r + dr[dir];
						int nc = cur.c + dc[dir];
						if (nl == -1 || nr == -1 || nc == -1 || nl == L || nr == R || nc == C)
							continue;
						if (map[nl][nr][nc] == 1)
							continue;
						if (map[nl][nr][nc] == -1) {// 정답
							flag = true;
							break w;
						}
						map[nl][nr][nc] = 1;
						q.add(new P(nl, nr, nc));
					}
				}
			}
			if (flag)
				sb.append("Escaped in " + cnt + " minute(s).\n");
			else
				sb.append("Trapped!\n");
			//
			str = br.readLine();
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}