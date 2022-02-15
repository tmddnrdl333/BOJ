package algorithm_ws.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11608kb
// 80mss

public class Main_1074_Z_정승욱 {
	static int fvalue = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 배열 크기 결정
		int N = Integer.parseInt(st.nextToken());
		// 한 변 길이
		int line = (int) Math.pow(2, N);

		// 계산할 위치 r,c
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int res = zvisit(line, N, r, c);
		bw.write(res + "");
		bw.flush();
		bw.close();
	}

	public static int zvisit(int line, int degree, int r, int c) {
		if (line == 2) {
			return fvalue + 2 * r + c;
		}

		boolean ud = true;
		boolean lr = true;

		if (r >= line / 2) {
			ud = false; // 하
			r -= line / 2;
		}
		if (c >= line / 2) {
			lr = false; // 우
			c -= line / 2;
		}

		int funit = (int) Math.pow(2, (degree - 1) * 2);
		if (ud && lr) {
			// 좌상
			// 그대로
		} else if (ud && !lr) {
			// 우상
			fvalue += funit;
		} else if (!ud && lr) {
			// 좌하
			fvalue += funit * 2;
		} else {
			// 우하
			fvalue += funit * 3;
		}

		return zvisit(line / 2, degree - 1, r, c);

	}
}
