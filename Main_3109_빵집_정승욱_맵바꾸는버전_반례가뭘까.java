package algorithm_ws.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3109_빵집_정승욱_맵바꾸는버전_반례가뭘까 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int[][] map;
	static int R, C;
	static int wayCnt = 0;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				char temp = str.charAt(j);
				if (temp == '.')
					map[i][j] = 0; // 길
				else
					map[i][j] = 5; // 벽
			}
		}

		mapchange();

		for (int i = 0; i < R; i++) {
			if (map[i][0] != 0)
				continue;
			flag = true;
			go(i, 0);
			for (int j = 0; j < R; j++)
				System.out.println(Arrays.toString(map[j]));
			System.out.println();
		}
		bw.write(Integer.toString(wayCnt));
		bw.flush();
		bw.close();

	}

	public static void go(int r, int c) {
		if (c == C - 1) {
			// 도착
			wayCnt++;
			flag = false;
			return;
		}

		if (r - 1 != -1 && map[r - 1][c + 1] == 0) {
			map[r - 1][c + 1] = 1;
			go(r - 1, c + 1);
			if (flag)
				map[r - 1][c + 1] = 0;
		} else if (map[r][c + 1] == 0) {
			map[r][c + 1] = 1;
			go(r, c + 1);
			if (flag)
				map[r][c + 1] = 0;
		} else if (r + 1 != R && map[r + 1][c + 1] == 0) {
			map[r + 1][c + 1] = 1;
			go(r + 1, c + 1);
			if (flag)
				map[r + 1][c + 1] = 0;
		}
		// 갈 수 없는 상황
		return;

	}

	public static void mapchange() {

		for (int j = C - 1; j > 0; j--) {
			if (map[0][j] + map[1][j] == 10)
				map[0][j - 1] = 5;
			if (map[R - 1][j] + map[R - 2][j] == 10)
				map[R - 1][j - 1] = 5;
			for (int i = 1; i < R - 1; i++) {
				if (map[i - 1][j] + map[i][j] + map[i + 1][j] == 15) {
					map[i][j - 1] = 5;
				}
			}
		}

	}

}