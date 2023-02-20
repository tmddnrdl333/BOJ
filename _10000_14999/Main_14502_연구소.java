package ps.BOJ._10000_14999;

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

// 132,188kb
// 720ms

public class Main_14502_연구소 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[][] map;
	static boolean[][] visit;

	static List<Integer> zero = new ArrayList<>();
	static int zSize;
	static int[] zArr;
	static List<Integer> one = new ArrayList<>();
	static List<Integer> two = new ArrayList<>();

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int cur = Integer.parseInt(st.nextToken());
				map[i][j] = cur;
				if (cur == 0)
					zero.add(i * M + j);
				else if (cur == 1)
					one.add(i * M + j);
				else if (cur == 2)
					two.add(i * M + j);
			}
		}

		zSize = zero.size();
		zArr = new int[zSize];
		for (int i = 1; i <= 3; i++)
			zArr[zSize - i] = 1;

		int max = 0;

		do {
			int cnt = N * M;
			// 정해진 zArr에 따라 visit에 넣어줌
			visit = new boolean[N][M];
			for (int i = 0; i < zSize; i++) {
				if (zArr[i] == 0)
					continue;
				int idx = zero.get(i);
				int r = idx / M;
				int c = idx % M;
				cnt--;
				visit[r][c] = true;
			}
			for (int idx : one) {
				cnt--;
				visit[idx / M][idx % M] = true;
			}

			Queue<int[]> q = new LinkedList<>();
			for (int idx : two) {
				int r = idx / M;
				int c = idx % M;
				cnt--;
				visit[r][c] = true;
				q.add(new int[] { r, c });
			}

			while (!q.isEmpty()) {
				int[] cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					if (nr == -1 || nc == -1 || nr == N || nc == M)
						continue;
					if (visit[nr][nc] || map[nr][nc] == 1)
						continue;
					cnt--;
					visit[nr][nc] = true;
					q.add(new int[] { nr, nc });
				}
			}
			max = cnt > max ? cnt : max;

		} while (np());

		bw.write(Integer.toString(max));
		bw.flush();
		bw.close();

	}

	public static boolean np() {

		int i = zSize - 1;
		while (i > 0 && zArr[i - 1] >= zArr[i])
			--i;

		if (i == 0)
			return false;

		int j = zSize - 1;
		while (zArr[i - 1] >= zArr[j])
			--j;

		swap(i - 1, j);

		int k = zSize - 1;
		while (i < k)
			swap(i++, k--);

		return true;
	}

	public static void swap(int i, int j) {
		int temp = zArr[i];
		zArr[i] = zArr[j];
		zArr[j] = temp;
	}
}