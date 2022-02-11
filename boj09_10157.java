package IM_practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 15808kb
// 116ms

public class boj09_10157 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		int[][] map = new int[R][C];
		int r = 0, c = 0, d = 0;
		boolean fail = false;
		int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		for (int i = 0; i < K - 1; i++) {
			if (map[r][c] == 1) {
				fail = true;
				break;
			}
			map[r][c] = 1;
			int nr = r + dir[d][0];
			int nc = c + dir[d][1];
			if (nr == -1 || nc == -1 || nr == R || nc == C || map[nr][nc] == 1) {
				d = (d + 1) % 4;
			}
			r = r + dir[d][0];
			c = c + dir[d][1];
		}

		if (fail) {
			bw.write("0");
			bw.flush();
			bw.close();
			return;
		}
		bw.write((c + 1) + " " + (r + 1));
		bw.flush();
		bw.close();
	}
}
