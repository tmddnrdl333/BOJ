package ps.BOJ._15000_19999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// 186,412kb
// 1,072ms

public class Main_16946_벽_부수고_이동하기_4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[][] map;
	static int[][] group;
	static List<Integer> gList = new ArrayList<>();

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		group = new int[N][M];

		for (int i = 0; i < N; i++) {
			char[] inp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++)
				map[i][j] = inp[j] - '0';
		}

		gList.add(0);
		int gi = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 이미 방문 -> 패스
				if (group[i][j] != 0)
					continue;
				// 벽 -> -1넣고 패스
				if (map[i][j] != 0) {
					group[i][j] = -1;
					continue;
				}

				// 공간 -> BFS로 채움
				Queue<Integer> q = new LinkedList<>();
				q.add(i * M + j);
				int cnt = 1;
				group[i][j] = gi;
				while (!q.isEmpty()) {
					int cur = q.poll();
					int r = cur / M, c = cur % M;
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d], nc = c + dc[d];
						if (nr == -1 || nr == N || nc == -1 || nc == M)
							continue;
						if (map[nr][nc] == 1)
							continue;
						if (group[nr][nc] != 0)
							continue;
						q.add(nr * M + nc);
						cnt++;
						group[nr][nc] = gi;
					}
				}
				gList.add(cnt);

				gi++;

			}
		}

		int[][] res = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (group[i][j] == -1) {
					res[i][j]++;
					Set<Integer> set = new HashSet<>();
					for (int d = 0; d < 4; d++) {
						int ni = i + dr[d], nj = j + dc[d];
						if (ni == -1 || ni == N || nj == -1 || nj == M)
							continue;
						if (map[ni][nj] == 0)
							set.add(group[ni][nj]);
					}
					for (int idx : set) {
						res[i][j] += gList.get(idx);
						res[i][j] %= 10;
					}
				} else
					continue;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(res[i][j]);
			}
			sb.append("\n");
		}
		sb.setLength(sb.length() - 1);

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}