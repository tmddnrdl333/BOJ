package ps.BOJ._20000_29999.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 136,504kb (메모리 비효율적임ㅠㅠ)
// 540ms

public class Main_20057_마법사_상어와_토네이도 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N;
	static int[][] map;
	static int out = 0;

	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { -1, 0, 1, 0 }; // 좌하우상

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		// 토네이도 이동
		int r = N / 2, c = N / 2;
		int dist = 1, d = 0;
		w: while (true) {

			for (int i = 0; i < dist; i++) {
				r += dr[d];
				c += dc[d];
				if (c == -1)
					break w;
				tornado(r, c, d);
			}
			d = (d + 1) % 4;

			for (int i = 0; i < dist; i++) {
				r += dr[d];
				c += dc[d];
				tornado(r, c, d);
			}
			dist++;
			d = (d + 1) % 4;
		}

		bw.write(Integer.toString(out));
		bw.flush();
		bw.close();
	}

	// d방향으로 이동해서 r,c 위치로 왔을 때 맵의 변화
	public static void tornado(int r, int c, int d) {
		int total = map[r][c]; // y위치의 원래 모래 양
		map[r][c] = 0; // y위치 비워주고
		int alpha = total; // alpha에 저장될 모래 (움직일때마다 차감)

//		어디로 몇만큼 어디로 몇만큼 몇번째인덱스(몇퍼센트)
//		1%: +2방향 1 +1방향 1
//			+2방향 1 +3방향 1
//		2%: +1방향 2
//			+3방향 2
//		5%: +0방향 2
//		7%: +1방향 1
//			+3방향 1
//		10%:+0방향 1 +1방향 1
//			+0방향 1 +3방향 1
		int[][] seq = { { 2, 1, 1, 1, 1 }, { 2, 1, 3, 1, 1 }, { 1, 2, 0, 0, 2 }, { 3, 2, 0, 0, 2 }, { 0, 2, 0, 0, 5 },
				{ 1, 1, 0, 0, 7 }, { 3, 1, 0, 0, 7 }, { 0, 1, 1, 1, 10 }, { 0, 1, 3, 1, 10 } };
		int tr = 0, tc = 0;
		for (int s = 0; s < 9; s++) {
			int d0 = (d + seq[s][0]) % 4, d2 = (d + seq[s][2]) % 4;
			tr = r + dr[d0] * seq[s][1] + dr[d2] * seq[s][3];
			tc = c + dc[d0] * seq[s][1] + dc[d2] * seq[s][3];
			int temp = seq[s][4] * total / 100;
			alpha -= temp;
			if (isOut(tr, tc))
				out += temp;
			else
				map[tr][tc] += temp;
		}

		tr = r + dr[d];
		tc = c + dc[d];
		if (isOut(tr, tc))
			out += alpha;
		else
			map[tr][tc] += alpha;
	}

	public static boolean isOut(int r, int c) {
		if (r < 0 || c < 0 || r >= N || c >= N)
			return true;
		return false;
	}
}