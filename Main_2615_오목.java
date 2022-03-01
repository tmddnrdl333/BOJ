package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,700kb
// 84ms

public class Main_2615_오목 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int[][] map = new int[19][19];

	static int[] dr = { -1, 0, 1, 1 };
	static int[] dc = { 1, 1, 1, 0 };

	static int[] ones = new int[2];
	static int[] twos = new int[2];

	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 19; i++)
			for (int j = 0; j < 19; j++)
				check(i, j);

		if (ones[0] == 0 && twos[0] == 0)
			bw.write("0");
		else if (ones[0] != 0 && twos[0] == 0)
			bw.write(1 + "\n" + ones[0] + " " + ones[1]);
		else if (ones[0] == 0 && twos[0] != 0)
			bw.write(2 + "\n" + twos[0] + " " + twos[1]);
		else
			bw.write(ones[0] + " " + ones[1] + " " + twos[0] + " " + twos[1]);
		bw.flush();
		bw.close();

	}

	public static void check(int r, int c) {
		int obj = map[r][c];
		if (obj == 0)
			return;

		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (nr == -1 || nc == -1 || nr == 19 || nc == 19)
				continue;
			if (map[nr][nc] != obj)
				continue;
			int br = r - dr[dir];
			int bc = c - dc[dir];
			if (br != -1 && bc != -1 && br != 19 && bc != 19)
				if (map[br][bc] == obj)
					continue;
			int cnt = 2;
			while (true) {
				nr += dr[dir];
				nc += dc[dir];
				if (nr == -1 || nc == -1 || nr == 19 || nc == 19)
					break;
				if (map[nr][nc] != obj)
					break;
				cnt++;
			}

			if (obj == 1 && cnt == 5) {
				ones[0] = r + 1;
				ones[1] = c + 1;
			}
			if (obj == 2 && cnt == 5) {
				twos[0] = r + 1;
				twos[1] = c + 1;
			}

		}
	}

}