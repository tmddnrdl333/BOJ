package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,624kb
// 76ms

public class Main_2578_빙고 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static boolean[][] map = new boolean[5][5];
	static int[] nums = new int[26]; // i번째 값의 의미 : i는 nums[i]/5 행 nums[i]%5 열에 있다.

	public static void main(String[] args) throws IOException {
		int idx = 0;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int val = Integer.parseInt(st.nextToken());
				nums[val] = idx++;
			}
		}

		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int val = Integer.parseInt(st.nextToken());
				int r = nums[val] / 5;
				int c = nums[val] % 5;
				map[r][c] = true;
				cnt++;
				if (cnt >= 12) {
					if (check()) {
						bw.write(Integer.toString(cnt));
						bw.flush();
						bw.close();
						return;
					}
				}

			}
		}

	}

	static boolean[] row = new boolean[5];
	static boolean[] col = new boolean[5];
	static boolean[] dia = new boolean[2];
	static int bingoCnt = 0;

	public static boolean check() {
		for (int i = 0; i < 5; i++) {
			if (!row[i]) {
				// check row if it's completed
				boolean flag = true;
				for (int j = 0; j < 5; j++)
					if (!map[i][j]) {
						flag = false;
						break;
					}
				if (flag) {
					row[i] = true;
					bingoCnt++;
				}
			}
			if (!col[i]) {
				// check
				boolean flag = true;
				for (int j = 0; j < 5; j++)
					if (!map[j][i]) {
						flag = false;
						break;
					}
				if (flag) {
					col[i] = true;
					bingoCnt++;
				}
			}
		}
		if (!dia[0]) {
			boolean flag = true;
			for (int i = 0; i < 5; i++)
				if (!map[i][i]) {
					flag = false;
					break;
				}
			if (flag) {
				dia[0] = true;
				bingoCnt++;
			}
		}
		if (!dia[1]) {
			boolean flag = true;
			for (int i = 0; i < 5; i++)
				if (!map[i][4 - i]) {
					flag = false;
					break;
				}
			if (flag) {
				dia[1] = true;
				bingoCnt++;
			}
		}
		return bingoCnt >= 3;
	}
}