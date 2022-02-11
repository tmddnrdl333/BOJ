package algorithm_ws.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 52844kb
// 400ms

public class Main_16927_배열돌리기2_정승욱 {
	static int N, M, R, min;
	static int[] size;
	static int[][] map;
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		// map -> arr
		min = Math.min(N, M) / 2;
		int[][] arr = new int[min][];
		size = new int[min];
		for (int i = 0; i < min; i++) {
			size[i] = 2 * M + 2 * N - 4 - 8 * i;
			arr[i] = new int[size[i]];
			int r = i, c = i, d = 0;
			for (int j = 0; j < size[i]; j++) {
				arr[i][j] = map[r][c];
				int nr = r + dir[d][0];
				int nc = c + dir[d][1];
				if (nr == i - 1 || nr == N - i || nc == i - 1 || nc == M - i)
					d = d + 1;
				r += dir[d][0];
				c += dir[d][1];
			}
		}
		// move array
		for (int i = 0; i < min; i++) {
			int tmpsize = size[i];
			int minR = R % tmpsize;
			int[] tmp = new int[tmpsize];
			for (int j = 0; j < tmpsize; j++) {
				tmp[j] = arr[i][(j + minR) % tmpsize];
			}
			for (int j = 0; j < tmpsize; j++) {
				arr[i][j] = tmp[j];
			}
		}
		// arr -> map
		for (int i = 0; i < min; i++) {
			int r = i, c = i, d = 0;
			for (int j = 0; j < size[i]; j++) {
				map[r][c] = arr[i][j];
				int nr = r + dir[d][0];
				int nc = c + dir[d][1];
				if (nr == i - 1 || nr == N - i || nc == i - 1 || nc == M - i)
					d = d + 1;
				r += dir[d][0];
				c += dir[d][1];
			}
		}

		// build string
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				sb.append(map[i][j] + " ");
			sb.append("\n");
		}
		// print
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
