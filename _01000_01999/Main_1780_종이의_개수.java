package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 316,256kb
// 732ms

public class Main_1780_종이의_개수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[][] map;

	static int[] res;

	public static void main(String[] args) throws IOException {
		res = new int[3];

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		exec(0, 0, N);

		bw.write(res[0] + "\n" + res[1] + "\n" + res[2]);
		bw.flush();
		bw.close();
	}

	static void exec(int r, int c, int len) {
		int num = map[r][c];

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (map[r + i][c + j] == num)
					continue;
				else {
					for (int a = 0; a < 3; a++)
						for (int b = 0; b < 3; b++)
							exec(r + (len / 3) * a, c + (len / 3) * b, len / 3);
					return;
				}
			}
		}

		res[num + 1]++;
	}
}