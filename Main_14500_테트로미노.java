package ing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 34020kb
// 440ms

public class Main_14500_테트로미노 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[][] map;
	static int max = 0;

	// -, |, ㅁ, ㄴ-, -ㄱ, s*2, ㅗ
	// s 네개 그릴 차례
	static int[][] dr = { { 0, 0, 0 }, { 1, 2, 3 }, // ㅡ ㅣ
			{ 1, 0, 1 }, // ㅁ
			{ 1, 1, 1 }, { 0, 1, 2 }, { 0, 0, 1 }, { 1, 2, 2 }, // ㄴ-
			{ 1, 2, 2 }, { 0, 0, 1 }, { 0, 1, 2 }, { 0, 0, -1 }, // ㅣㄴ
			{ 0, -1, -1 }, { 1, 1, 2 }, // _|-
			{ 0, 1, 1 }, { 1, 1, 2 }, // -|_
			{ 0, -1, 0 }, { 1, 1, 2 }, { 0, 1, 0 }, { 1, 1, 2 } // ㅗ
	};
	static int[][] dc = { { 1, 2, 3 }, { 0, 0, 0 }, //
			{ 0, 1, 1 }, //
			{ 0, 1, 2 }, { 1, 0, 0 }, { 1, 2, 2 }, { 0, 0, -1 }, //
			{ 0, 0, 1 }, { 1, 2, 0 }, { 1, 1, 1 }, { 1, 2, 2 }, //
			{ 1, 1, 2 }, { 0, 1, 1 }, //
			{ 1, 1, 2 }, { 0, -1, -1 }, //
			{ 1, 1, 2 }, { 0, 1, 0 }, { 1, 1, 2 }, { 0, -1, 0 } //
	};

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int type = 0; type < 19; type++) {

					try {
						int temp = sum(type, i, j);
						max = temp > max ? temp : max;
					} catch (Exception e) {
						continue;
					}

				}
			}
		}
		System.out.println(max);

	}

	public static int sum(int type, int r, int c) throws Exception {
		int sum = map[r][c];
		int[] tdr = dr[type];
		int[] tdc = dc[type];
		for (int i = 0; i < 3; i++) {
			int nr = r + tdr[i], nc = c + tdc[i];
			sum += map[nr][nc];
		}
		return sum;
	}

}
