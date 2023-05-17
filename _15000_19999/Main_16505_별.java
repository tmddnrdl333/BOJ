package ps.BOJ._15000_19999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 20,424kb
// 144ms

public class Main_16505_별 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	static char[][] map;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int n = (int) Math.pow(2, N);
		map = new char[n][n];
		for (int i = 0; i < n; i++)
			Arrays.fill(map[i], ' ');

		rec(0, 0, n);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void rec(int i, int j, int len) {
		for (int c = j; c < j + len; c++)
			map[i][c] = '*';
		for (int r = i + 1; r < i + len; r++) {
			map[r][j] = '*';
			map[r][j + len - (r - i) - 1] = '*';
		}
		if (len > 2) {
			rec(i, j, len / 2);
			rec(i, j + len / 2, len / 2);
			rec(i + len / 2, j, len / 2);
		}
	}
}