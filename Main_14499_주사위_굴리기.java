package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 12,244kb
// 88ms

public class Main_14499_주사위_굴리기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 }; // 우좌상하

	static int[] dice = new int[6];;

	public static void roll(int dir) {
		int temp = dice[5];
		switch (dir) {
		case 0:
			dice[5] = dice[2];
			dice[2] = dice[0];
			dice[0] = dice[3];
			dice[3] = temp;
			break;
		case 1:
			dice[5] = dice[3];
			dice[3] = dice[0];
			dice[0] = dice[2];
			dice[2] = temp;
			break;
		case 2:
			dice[5] = dice[1];
			dice[1] = dice[0];
			dice[0] = dice[4];
			dice[4] = temp;
			break;
		case 3:
			dice[5] = dice[4];
			dice[4] = dice[0];
			dice[0] = dice[1];
			dice[1] = temp;
			break;
		}
	}

	static int N, M, r, c, K;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int cmd = Integer.parseInt(st.nextToken()) - 1;

			// 지도에서 이동
			int nr = r + dr[cmd], nc = c + dc[cmd];
			if (nr == -1 || nc == -1 || nr == N || nc == M)
				continue;
			r = nr;
			c = nc;

			// 주사위 굴리기
			roll(cmd);

			// 복사
			if (map[r][c] == 0) {
				map[r][c] = dice[5];
			} else {
				dice[5] = map[r][c];
				map[r][c] = 0;
			}

			sb.append(dice[0] + "\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}