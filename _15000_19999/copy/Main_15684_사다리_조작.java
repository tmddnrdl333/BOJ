package ps.BOJ._15000_19999.copy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 15,692kb
// 1568ms

public class Main_15684_사다리_조작 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, G;
	static int[][] map;
	static List<Integer> list = new ArrayList<>();
	static int lSize, res = -1;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // | 가능한 개수
		G = Integer.parseInt(st.nextToken()); // 주어진 - 개수
		N = Integer.parseInt(st.nextToken()); // - 가능한 개수
		map = new int[N][M - 1];
		for (int i = 0; i < G; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1, b = Integer.parseInt(st.nextToken()) - 1;
			map[a][b] = 1;
			if (b != 0)
				map[a][b - 1] = -1;
			if (b != M - 2)
				map[a][b + 1] = -1;
		}

		// 가능한 빈자리
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M - 1; j++)
				if (map[i][j] == 0)
					list.add(i * (M - 1) + j);
		lSize = list.size();

		for (int i = 0; i <= 3; i++) {
			test(i, 0);
			if (res != -1)
				break;
		}

		System.out.println(res);

	}

	public static boolean isAns() {
		for (int j = 0; j < M; j++) {
			// j번 출발
			int posi = j;
			for (int i = 0; i < N; i++) {
				if (posi != M - 1)
					if (map[i][posi] > 0) {
						posi++;
						continue;
					}
				if (posi != 0)
					if (map[i][posi - 1] > 0) {
						posi--;
						continue;
					}
			}
			if (posi != j)
				return false;
		}
		return true;
	}

	public static void test(int targetCnt, int cnt) {
		if (cnt == targetCnt) {
			if (isAns())
				res = cnt;
			return;
		}
		for (int idx : list) {
			int i = idx / (M - 1), j = idx % (M - 1);
			if (map[i][j] == 0) {
				map[i][j] = 2;
				test(targetCnt, cnt + 1);
				map[i][j] = 0;
			}
		}
	}
}