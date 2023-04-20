package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 239,156kb
// 480ms

public class Main_2146_다리_만들기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static class Pnt {
		int r, c;

		Pnt(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = -Integer.parseInt(st.nextToken());
		}

		List<Queue<Pnt>> list = new ArrayList<>();
		list.add(new LinkedList<>());

		int num = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == -1) {

					list.add(new LinkedList<>());
					Queue<Pnt> q = new LinkedList<>();
					q.add(new Pnt(i, j));
					map[i][j] = num;
					while (!q.isEmpty()) {
						Pnt cp = q.poll();
						for (int d = 0; d < 4; d++) {
							int nr = cp.r + dr[d], nc = cp.c + dc[d];
							if (nr == -1 || nr == N || nc == -1 || nc == N)
								continue;
							if (map[nr][nc] == 0) {
								map[nr][nc] = -2;
								list.get(num).add(new Pnt(nr, nc));
							}
							if (map[nr][nc] != -1)
								continue;
							q.add(new Pnt(nr, nc));
							map[nr][nc] = num;
						}
					}

					num++;
				}
			}
		}

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (map[i][j] == -2)
					map[i][j] = 0;

		int res = Integer.MAX_VALUE;

		for (int i = 1; i < num; i++) {
			Queue<Pnt> candidate = list.get(i);
			while (!candidate.isEmpty()) {
				Pnt startPnt = candidate.poll();

				int[][] tmpMap = new int[N][N];
				for (int a = 0; a < N; a++)
					for (int b = 0; b < N; b++)
						tmpMap[a][b] = map[a][b];

				Queue<Pnt> findQ = new LinkedList<>();
				findQ.add(startPnt);
				tmpMap[startPnt.r][startPnt.c] = -1;

				int cnt = 0;

				findBFS: while (!findQ.isEmpty()) {
					int qSize = findQ.size();
					cnt++;
					if (cnt > res)
						break;
					for (; qSize > 0; qSize--) {
						Pnt curPnt = findQ.poll();
						for (int d = 0; d < 4; d++) {
							int nr = curPnt.r + dr[d], nc = curPnt.c + dc[d];
							if (nr == -1 || nr == N || nc == -1 || nc == N)
								continue;
							// 자기 자신으로 돌아오거나 이미 온 길이면 패스
							if (tmpMap[nr][nc] == i || tmpMap[nr][nc] == -1)
								continue;
							// 빈공간이면 큐에 추가
							if (tmpMap[nr][nc] == 0) {
								findQ.add(new Pnt(nr, nc));
								tmpMap[nr][nc] = -1;
							}
							// 그 외의 숫자면 도착했다는 뜻!
							else {
								res = cnt < res ? cnt : res;
								break findBFS;
							}

						}
					}
				}

			}
		}

		bw.write(res + "");
		bw.flush();
		bw.close();

	}
}