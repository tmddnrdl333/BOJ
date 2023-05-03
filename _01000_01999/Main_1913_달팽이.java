package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 177,832kb
// 488ms

public class Main_1913_달팽이 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];

		int r = 0, c = 0;
		int num = N * N;
		int dir = 0;
		int kr = 0, kc = 0;
		while (num != 0) {
			if (num == K) {
				kr = r + 1;
				kc = c + 1;
			}
			map[r][c] = num--;
			r += dr[dir];
			c += dc[dir];
			if (r == -1 || c == -1 || r == N || c == N || map[r][c] != 0) {
				r -= dr[dir];
				c -= dc[dir];
				dir = (dir + 1) % 4;
				r += dr[dir];
				c += dc[dir];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		sb.append(kr + " " + kc);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}