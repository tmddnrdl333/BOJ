package ps.BOJ._15000_19999.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 54,436kb
// 432ms

public class Main_16967_배열_복원하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int[][] B = new int[H + X][W + Y];
		for (int i = 0; i < H + X; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W + Y; j++)
				B[i][j] = Integer.parseInt(st.nextToken());
		}

		int[][] A = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				int ii = i - X, jj = j - Y;
				if (ii < 0 || jj < 0)
					A[i][j] = B[i][j];
				else
					A[i][j] = B[i][j] - A[ii][jj];
			}
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++)
				sb.append(A[i][j] + " ");
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}