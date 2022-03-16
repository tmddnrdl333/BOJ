package study.day0315;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 272,776kb
// 484ms

public class Main_2448_별_찍기_11 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][2 * N - 1];
		recursion(N, 0, 0);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2 * N - 1; j++)
				sb.append(map[i][j] == 1 ? '*' : ' ');
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int[][] unit = new int[][] { { 0, 0, 1, 0, 0 }, { 0, 1, 0, 1, 0 }, { 1, 1, 1, 1, 1 } };

	public static void fill(int r, int c) {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 5; j++)
				map[r + i][c + j] = unit[i][j];
	}

	public static void recursion(int n, int r, int c) {
		if (n == 3) {
			fill(r, c);
			return;
		}
		recursion(n / 2, r, c + n / 2);
		recursion(n / 2, r + n / 2, c);
		recursion(n / 2, r + n / 2, c + n);
	}
}