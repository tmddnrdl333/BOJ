package ps.BOJ._10000_14999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,648kb
// 84ms

public class Main_10830_행렬_제곱 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static long B;
	static long[][] arr;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		arr = new long[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				arr[i][j] = Long.parseLong(st.nextToken());
		}

		long[][] res = calc(arr, B);
		res = check(res);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				sb.append(res[i][j]).append(" ");
			sb.setLength(sb.length() - 1); // 이거 필요?
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static long[][] calc(long[][] a, long b) {
		if (b == 1) {
			return a;
		}
		long[][] temp = calc(a, b / 2);
		if (b % 2 == 0) {
			return mult(temp, temp);
		} else {
			return mult(mult(temp, temp), arr);
		}
	}

	public static long[][] mult(long[][] a, long[][] b) {
		long[][] res = new long[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				long cur = 0l;
				for (int k = 0; k < N; k++) {
					cur += a[i][k] * b[k][j] % 1000;
					cur %= 1000;
				}
				res[i][j] = cur % 1000;
			}
		}
		return res;
	}

	public static long[][] check(long[][] a) {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				a[i][j] %= 1000;
		return a;
	}

//	public static void test(long[][] a) {
//		System.out.println("!!");
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(a[i]));
//		}
//		System.out.println("!!");
//	}
}