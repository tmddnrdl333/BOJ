package ps.BOJ._10000_14999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 15,204kb
// 236ms

public class Main_11049_행렬_곱셈_순서 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;

	static int N;
	static int[][] arr;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		dp = new int[N + 1][N + 1];

		for (int i = 1; i < N; i++)
			dp[i][i + 1] = arr[i][0] * arr[i + 1][0] * arr[i + 1][1];
//		test();

		for (int gap = 2; gap < N; gap++) {
			for (int i = 1; i <= N - gap; i++) {
				int j = i + gap;
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + (arr[i][0] * arr[k][1] * arr[j][1]));
				}
//				test();
			}
		}
		bw.write(Integer.toString(dp[1][N]));
		bw.flush();
		bw.close();
	}

	public static void test() {
		for (int i = 0; i <= N; i++)
			System.out.println(Arrays.toString(dp[i]));
		System.out.println();
	}
}