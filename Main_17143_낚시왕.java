package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// 167,064kb
// 660ms

public class Main_17143_낚시왕 {
	static class Shark {
		int r, c, s, d, z;

		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 }; // 상 우 하 좌

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int R, C, M;
	static int[][] map;
	static Map<Integer, Shark> sharks;
	static int res = 0;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		sharks = new HashMap<>();
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) - 1;
			if (d == 1)
				d = 2;
			else if (d == 2)
				d = 1;
			int z = Integer.parseInt(st.nextToken());
			map[r][c] = i;
			sharks.put(i, new Shark(r, c, s, d, z));
		}

		for (int j = 0; j < C; j++) {
			int i = 0;
			while (i < R) {
				if (map[i][j] != 0)
					break;
				i++;
			}
			if (i != R) {
				int caught = map[i][j];
				map[i][j] = 0;
				res += sharks.get(caught).z;
				sharks.remove(caught);
			}

			List<int[]> list = new ArrayList<>(); // 몇번 상어가 어디어디에 어느방향으로
			for (int sn : sharks.keySet()) {
				Shark cur = sharks.get(sn);
				int nr = cur.r;
				int nc = cur.c;
				int s = cur.s;
				int d = cur.d;
				map[nr][nc] = 0;

				if (d % 2 == 0) { // 상하
					s %= (2 * R - 2);
					nr += dr[d] * s;
					if (nr < 0) {
						if (nr > -R) {
							nr = -nr;
							d = (d + 2) % 4;
						} else {
							nr += (2 * R - 2);
						}
					} else if (nr >= R) {
						if (nr < 2 * R - 2) {
							nr = 2 * R - 2 - nr;
							d = (d + 2) % 4;
						} else {
							nr -= (2 * R - 2);
						}
					}
				} else { // 좌우
					s %= (2 * C - 2);
					nc += dc[d] * s;
					if (nc < 0) {
						if (nc > -C) {
							nc = -nc;
							d = (d + 2) % 4;
						} else {
							nc += (2 * C - 2);
						}
					} else if (nc >= C) {
						if (nc < 2 * C - 2) {
							nc = 2 * C - 2 - nc;
							d = (d + 2) % 4;
						} else {
							nc -= (2 * C - 2);
						}
					}
				}
				list.add(new int[] { sn, nr, nc, d });
			}

			for (int[] arr : list) {
				int sn = arr[0];
				int r = arr[1], c = arr[2];
				int s = sharks.get(arr[0]).s;
				int z = sharks.get(arr[0]).z;
				sharks.put(sn, new Shark(r, c, s, arr[3], z));
				if (map[r][c] != 0) {
					if (z > sharks.get(map[r][c]).z) {
						sharks.remove(map[r][c]);
						map[r][c] = sn;
					} else {
						sharks.remove(sn);
					}
				} else {
					map[r][c] = sn;
				}
			}
		}
		bw.write(Integer.toString(res));
		bw.flush();
		bw.close();
	}
}