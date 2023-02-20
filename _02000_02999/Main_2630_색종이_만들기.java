package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 13,164kb
// 116ms

public class Main_2630_색종이_만들기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[][] map;
	static int[] cnt;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		cnt = new int[2];
		checkncut(0, 0, N);
		bw.write(cnt[0] + "\n" + cnt[1]);
		bw.flush();
		bw.close();

	}

	public static void checkncut(int r, int c, int len) {
		if (len == 1) {
			cnt[map[r][c]]++;
			return;
		}
		boolean flag = true;
		int color = map[r][c];
		for (int i = r; i < r + len; i++) {
			for (int j = c; j < c + len; j++) {
				if (map[i][j] != color) {
					flag = false;
					break;
				}
			}
		}

		if (flag) {
			cnt[color]++;
		} else {
			checkncut(r, c, len / 2);
			checkncut(r, c + len / 2, len / 2);
			checkncut(r + len / 2, c, len / 2);
			checkncut(r + len / 2, c + len / 2, len / 2);
		}
	}
}