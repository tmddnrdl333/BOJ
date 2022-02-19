package study.day0217;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 35,144kb
// 432ms

public class study_boj_9204_체스 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static StringBuilder sb = new StringBuilder();

	static int[][] map;
	static int[][] d = { { -1, -1 }, { -1, 1 }, { 1, 1 }, { 1, -1 } };

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			char inp1 = st.nextToken().charAt(0);
			int inp2 = Integer.parseInt(st.nextToken());
			char inp3 = st.nextToken().charAt(0);
			int inp4 = Integer.parseInt(st.nextToken());
			int x2 = inp1 - 'A';
			int x1 = 8 - inp2;
			int y2 = inp3 - 'A';
			int y1 = 8 - inp4;
			// r = x1 , c = x2 -> r = y1 , c = y2
			// 0 <= r,c <=7

			if ((x1 + x2 + y1 + y2) % 2 != 0) {
				sb.append("Impossible").append("\n");
			} else {
				//
				int dr = y1 - x1;
				int dc = y2 - x2;
				if (dr == 0 && dc == 0) {
					sb.append("0 " + inp1 + " " + inp2 + "\n");
				} else if (dr == dc || dr == -dc) {
					sb.append("1 " + inp1 + " " + inp2 + " " + inp3 + " " + inp4 + "\n");
				} else {
					sb.append("2 " + inp1 + " " + inp2 + " ");
					//
					move(x1, x2, y1, y2);
					//
					sb.append(inp3 + " " + inp4 + "\n");
				}
				//
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static void move(int x1, int x2, int y1, int y2) {
		map = new int[8][8];
		int r = 0, c = 0;
		for (int dir = 0; dir < 4; dir++) {
			for (int i = -7; i < 8; i++) {
				try {
					r = x1 + i * d[dir][0];
					c = x2 + i * d[dir][1];
					map[r][c] = 1;
				} catch (Exception e) {
				}
			}
		}
		o: for (int dir = 0; dir < 4; dir++) {
			for (int i = -7; i < 8; i++) {
				if (i == 0)
					continue;
				try {
					r = y1 + i * d[dir][0];
					c = y2 + i * d[dir][1];
					map[r][c]++;
					if (map[r][c] == 2) {
						break o;
					}
				} catch (Exception e) {
				}
			}
		}
		// r과 c로 좌표를 만들어서 반환
		char tempChar = (char) (c + 'A');
		int tempInt = 8 - r;
		sb.append(tempChar + " " + tempInt + " ");
	}
}
