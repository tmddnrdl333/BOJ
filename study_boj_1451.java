package study.day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class study_boj_1451 {
	static int N, M;
	static long[][] arr;
	static long s1, s2, s3;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new long[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		long[] max = new long[6];
		// 0:|| 1:= 2:ㅗㅓㅜㅏ
		if (M > 2) {
			max[0] = split1();
		}
		if (N > 2) {
			max[1] = split2();
		}
		if (M > 1 && N > 1) {
			max[2] = split3u();
			max[3] = split3l();
			max[4] = split3d();
			max[5] = split3r();
		}
		long rmax = 0;
		for (int i = 0; i < 6; i++) {
			rmax = max[i] > rmax ? max[i] : rmax;
		}
		System.out.println(rmax);

		//

	}

	public static void initialize() {
		s1 = 0;
		s2 = 0;
		s3 = 0;
	}

	public static long calc(int a0, int a1, int b0, int b1) {
		long res = 0;
		for (int i = a0; i <= b0; i++) {
			for (int j = a1; j <= b1; j++) {
				res += arr[i][j];
			}
		}
		return res;

	}

	public static long split1() {
		long res = 0;
		long max = 0;
		for (int i = 1; i <= M - 2; i++) {
			for (int j = i; j <= M - 2; j++) {
				s1 = calc(0, 0, N - 1, i - 1);
				s2 = calc(0, i, N - 1, j);
				s3 = calc(0, j + 1, N - 1, M - 1);
				res = s1 * s2 * s3;
				max = res > max ? res : max;
			}
		}
		return max;
	}

	public static long split2() {
		long res = 0;
		long max = 0;
		for (int i = 1; i <= N - 2; i++) {
			for (int j = i; j <= N - 2; j++) {
				s1 = calc(0, 0, i - 1, M - 1);
				s2 = calc(i, 0, j, M - 1);
				s3 = calc(j + 1, 0, N - 1, M - 1);
				res = s1 * s2 * s3;
				max = res > max ? res : max;
			}
		}
		return max;
	}

//1
	public static long split3u() {
		long res = 0;
		long max = 0;
		for (int i = 0; i <= N - 2; i++) {
			for (int j = 0; j <= M - 2; j++) {
				s1 = calc(0, 0, i, j);
				s2 = calc(0, j + 1, i, M - 1);
				s3 = calc(i + 1, 0, N - 1, M - 1);
				res = s1 * s2 * s3;
				max = res > max ? res : max;
			}
		}
		return max;
	}

//2
	public static long split3l() {
		long res = 0;
		long max = 0;
		for (int i = 0; i <= N - 2; i++) {
			for (int j = 0; j <= M - 2; j++) {
				s1 = calc(0, 0, i, j);
				s2 = calc(i + 1, 0, N - 1, j);
				s3 = calc(0, j + 1, N - 1, M - 1);
				res = s1 * s2 * s3;
				max = res > max ? res : max;
			}
		}
		return max;
	}

//3
	public static long split3d() {
		long res = 0;
		long max = 0;
		for (int i = 1; i <= N - 1; i++) {
			for (int j = 1; j <= M - 1; j++) {
				s1 = calc(0, 0, i - 1, M - 1);
				s2 = calc(i, 0, N - 1, j - 1);
				s3 = calc(i, j, N - 1, M - 1);
				res = s1 * s2 * s3;
				max = res > max ? res : max;
			}
		}
		return max;
	}

//4
	public static long split3r() {
		long res = 0;
		long max = 0;
		for (int i = 1; i <= N - 1; i++) {
			for (int j = 1; j <= M - 1; j++) {
				s1 = calc(0, 0, N - 1, j - 1);
				s2 = calc(0, j, i - 1, M - 1);
				s3 = calc(i, j, N - 1, M - 1);
				res = s1 * s2 * s3;
				max = res > max ? res : max;
			}
		}
		return max;
	}
}
