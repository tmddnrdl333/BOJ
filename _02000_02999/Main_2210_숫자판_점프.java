package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 14,492kb
// 100ms

public class Main_2210_숫자판_점프 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int[][] map = new int[5][5];
	static Set<Integer> set = new HashSet<>();
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < 25; i++)
			DFS(0, map[i / 5][i % 5], i);

		System.out.println(set.size());
	}

	public static void DFS(int cnt, int num, int idx) {
		if (cnt == 5) {
			set.add(num);
			return;
		}
		int r = idx / 5, c = idx % 5;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d], nc = c + dc[d];
			if (nr == -1 || nc == -1 || nr == 5 || nc == 5)
				continue;
			int nnum = num * 10 + map[nr][nc];
			int nidx = nr * 5 + nc;
			DFS(cnt + 1, nnum, nidx);
		}
	}
}