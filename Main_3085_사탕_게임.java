package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 11,988kb
// 136ms

public class Main_3085_사탕_게임 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();
		int max = countRowAndCol();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (swap(i, j, true)) {
					int temp = countRowAndCol();
					max = temp > max ? temp : max;
					swap(i, j, true);
				}
				if (swap(i, j, false)) {
					int temp = countRowAndCol();
					max = temp > max ? temp : max;
					swap(i, j, false);
				}
			}
		}
		System.out.println(max);
	}

	static boolean swap(int r, int c, boolean flag) {
		char temp = '.';
		if (flag) {
			if (r + 1 == N)
				return false;
			temp = map[r + 1][c];
			map[r + 1][c] = map[r][c];
		} else {
			if (c + 1 == N)
				return false;
			temp = map[r][c + 1];
			map[r][c + 1] = map[r][c];
		}
		map[r][c] = temp;
		return true;
	}

	static int countRowAndCol() {
		int max = 0;
		for (int i = 0; i < N; i++) {
			int icm = countCol(i), irm = countRow(i);
			max = icm > max ? icm : max;
			max = irm > max ? irm : max;
		}
		return max;
	}

	static int countCol(int r) {
		int cnt = 1, max = 0;
		char before = '.';
		for (int i = 0; i < N; i++) {
			char now = map[r][i];
			if (now == before) {
				cnt++;
				max = cnt > max ? cnt : max;
			} else {
				cnt = 1;
			}
			before = now;
		}
		return max;
	}

	static int countRow(int c) {
		int cnt = 1, max = 0;
		char before = '.';
		for (int i = 0; i < N; i++) {
			char now = map[i][c];
			if (now == before) {
				cnt++;
				max = cnt > max ? cnt : max;
			} else {
				cnt = 1;
			}
			before = now;
		}
		return max;
	}
}
