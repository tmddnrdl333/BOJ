package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 15,080kb
// 284ms

public class Main_1799_비숍 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N;
	static int[][] map;
	static int[] dr = { -1, -1 };
	static int[] dc = { -1, 1 };
	static List<Integer> white = new ArrayList<>();
	static List<Integer> black = new ArrayList<>();
	static int whiteSize, blackSize;
	static int wCnt = 0, wMax = 0;
	static int bCnt = 0, bMax = 0;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int cur = Integer.parseInt(st.nextToken());
				map[i][j] = cur;
				if (cur == 1) {
					if ((i + j) % 2 == 0)
						white.add(i * N + j);
					else
						black.add(i * N + j);
				}
			}
		}

		whiteSize = white.size();
		blackSize = black.size();

		setW(0);
		setB(0);

		System.out.println(wMax + bMax);
	}

	public static void setW(int li) {
		if (li == whiteSize) {
			wMax = wCnt > wMax ? wCnt : wMax;
			return;
		}
		int idx = white.get(li);
		int r = idx / N, c = idx % N;
		if (isAvailable(idx)) {
			map[r][c] = 2;
			wCnt++;
			setW(li + 1);
			map[r][c] = 1;
			wCnt--;
		}
		setW(li + 1);
	}

	public static void setB(int li) {
		if (li == blackSize) {
			bMax = bCnt > bMax ? bCnt : bMax;
			return;
		}
		int idx = black.get(li);
		int r = idx / N, c = idx % N;
		if (isAvailable(idx)) {
			map[r][c] = 2;
			bCnt++;
			setB(li + 1);
			map[r][c] = 1;
			bCnt--;
		}
		setB(li + 1);
	}

	public static boolean isAvailable(int idx) {
		int r = idx / N, c = idx % N;
		for (int d = 0; d < 2; d++) {
			int nr = r + dr[d], nc = c + dc[d];
			while (true) {
				if (nr == -1 || nc == -1 || nr == N || nc == N)
					break;
				if (map[nr][nc] == 2)
					return false;
				nr += dr[d];
				nc += dc[d];
			}
		}
		return true;
	}
}