package study.day0419;

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

// 46,252kb
// 356ms

public class Main_20058_마법사_상어와_파이어스톰 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, Q;
	static int[][] map;
	static int size;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		size = 1 << N;
		map = new int[size][size];

		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			int L = Integer.parseInt(st.nextToken());

			firestorm(L);
		}

		int[] res = count();
		bw.write(res[0] + "\n" + res[1]);
		bw.flush();
		bw.close();

	}

	public static void firestorm(int L) {
		// 한 조각의 변 길이는?
		// 2^L = 1<<L
		int len = 1 << L;

		if (L != 0) // L이 0이면 회전할 필요 없고 녹기만 하면 됨
			for (int i = 0; i < size; i += len) {
				for (int j = 0; j < size; j += len) {
					rotate(i, j, len);
				}
			}
		melt();
	}

	public static void rotate(int r, int c, int len) {
		int[][] temp = new int[len][len];
		for (int i = 0; i < len; i++)
			for (int j = 0; j < len; j++)
				temp[j][len - 1 - i] = map[r + i][c + j];
		for (int i = 0; i < len; i++)
			for (int j = 0; j < len; j++)
				map[r + i][c + j] = temp[i][j];
	}

	public static void melt() {
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (map[i][j] == 0) // 이미 얼음이 없으면 녹을 수 없음
					continue;
				int emptyCnt = 0; // 인접한 얼음 없는 칸의 수 count
				for (int d = 0; d < 4; d++) {
					int r = i + dr[d], c = j + dc[d];
					if (isEmpty(r, c))
						emptyCnt++;
				}
				if (emptyCnt > 1)
					list.add(new int[] { i, j });
			}
		}
		for (int[] arr : list) {
			map[arr[0]][arr[1]]--;
		}
	}

	public static boolean isEmpty(int r, int c) {
		if (r == -1 || c == -1 || r == size || c == size)
			return true;
		if (map[r][c] == 0)
			return true;
		return false;
	}

	public static int[] count() {
		int[] res = new int[2];

		int totalCnt = 0, max = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (map[i][j] == 0)
					continue;
				// BFS
				int cnt = 1;
				Queue<int[]> q = new LinkedList<>();
				totalCnt += map[i][j];
				map[i][j] = 0;
				q.add(new int[] { i, j });
				while (!q.isEmpty()) {
					int[] cur = q.poll();
					for (int d = 0; d < 4; d++) {
						int r = cur[0] + dr[d], c = cur[1] + dc[d];
						if (r == -1 || c == -1 || r == size || c == size)
							continue;
						if (map[r][c] != 0) {
							cnt++;
							totalCnt += map[r][c];
							map[r][c] = 0;
							q.add(new int[] { r, c });
						}
					}
				}
				max = cnt > max ? cnt : max;
			}
		}

		res[0] = totalCnt;
		res[1] = max;
		return res;
	}
}