package ps.BOJ._15000_19999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 12,540kb
// 104ms

public class Main_15739_매직스퀘어 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());

		boolean error = false;
		boolean[] check = new boolean[N * N];
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int inp = Integer.parseInt(st.nextToken());
				map[i][j] = inp;
				if (inp - 1 > N * N - 1 || check[inp - 1]) {
					error = true;
					break;
				} else
					check[inp - 1] = true;
			}
		}

		int magic = N * (N * N + 1) / 2;

		int[] r = new int[N];
		int[] c = new int[N];

		if (!error)
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					r[i] += map[i][j];
					c[i] += map[j][i];
				}
				if (r[i] != magic || c[i] != magic) {
					error = true;
					break;
				}
			}

		int d1 = 0, d2 = 0;
		if (!error) {
			for (int i = 0; i < N; i++) {
				d1 += map[i][i];
				d2 += map[N - 1 - i][i];
			}
		}
		if (d1 != magic || d2 != magic)
			error = true;

		if (error)
			bw.write("FALSE");
		else
			bw.write("TRUE");
		bw.flush();
		bw.close();

	}
}