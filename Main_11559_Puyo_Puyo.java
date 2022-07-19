package study.day0717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 12,200kb
// 80ms

public class Main_11559_Puyo_Puyo {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static char[][] map = new char[12][6];
	static boolean[][] check = new boolean[12][6];

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 12; i++)
			map[i] = br.readLine().toCharArray();

		int cnt = 0;
		boolean flag = true;
		while (flag) {
			flag = false;
			for (int idx = 0; idx < 72; idx++)
				if (!check[idx / 6][idx % 6])
					if (boom(idx))
						flag = true;
			if (flag)
				cnt++;
			fall();
			reset();
		}
		System.out.println(cnt);

	}

	// puyo!
	public static boolean boom(int idx) {
		Queue<Integer> puyo = new LinkedList<>();

		Queue<Integer> q = new LinkedList<>();
		char color = map[idx / 6][idx % 6];

		q.add(idx);
		puyo.add(idx);
		check[idx / 6][idx % 6] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();
			int r = cur / 6, c = cur % 6;
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d], nc = c + dc[d];
				if (nr == -1 || nc == -1 || nr == 12 || nc == 6)
					continue;
				if (check[nr][nc])
					continue;
				if (map[nr][nc] == color) {
					q.add(nr * 6 + nc);
					puyo.add(nr * 6 + nc);
					check[nr][nc] = true;
				}
			}
		}

		if (color != '.' && puyo.size() >= 4) {
			while (!puyo.isEmpty()) {
				int cur = puyo.poll();
				map[cur / 6][cur % 6] = '.';
			}
			return true;
		}
		return false;
	}

	public static void fall() {
		for (int j = 0; j < 6; j++) {
			List<Character> list = new ArrayList<>();
			int i = 11;
			for (; i >= 0; i--)
				if (map[i][j] != '.') {
					list.add(map[i][j]);
					map[i][j] = '.';
				}
			i = 11;
			for (char c : list)
				map[i--][j] = c;
		}
	}

	public static void reset() {
		for (int i = 0; i < 12; i++)
			check[i] = new boolean[6];
	}
}