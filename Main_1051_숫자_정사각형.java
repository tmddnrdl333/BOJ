package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 12,056kb
// 92ms

public class Main_1051_숫자_정사각형 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++) {
				int temp = find(i, j);
				max = temp > max ? temp : max;
			}

		bw.write(Integer.toString(max));
		bw.flush();
		bw.close();
	}

	public static int find(int r, int c) {
		int val = map[r][c];
		int max = 1;
		// 정사각형으로 바꿔주면 된다.
		int len = 0;
		int nr = r;
		int nc = c;
		while (true) {
			nr = r + len;
			nc = c + len;
			if (nr == N || nc == M)
				break;
			if (map[nr][nc] == val && map[r][nc] == val && map[nr][c] == val) {
				int temp = (len + 1) * (len + 1);
				max = temp > max ? temp : max;
			}
			len++;
		}
		return max;
	}
}