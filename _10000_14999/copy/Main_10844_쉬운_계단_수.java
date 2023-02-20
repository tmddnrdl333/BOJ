package ps.BOJ._10000_14999.copy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 11,516kb
// 76ms

public class Main_10844_쉬운_계단_수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static final int mod = 1000000000;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N + 1][10];

		// 첫 자리는
		// 0 빼고 1~9는 모두 하나씩
		for (int j = 1; j <= 9; j++) {
			dp[1][j] = 1;
		}
		// 두번째 자리부터
		for (int i = 2; i <= N; i++) {
			dp[i][0] = dp[i - 1][1];
			dp[i][9] = dp[i - 1][8];
			for (int j = 1; j <= 8; j++)
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
		}
		long sum = 0;
		for (int j = 0; j <= 9; j++)
			sum = (sum + dp[N][j]) % mod;

		System.out.println(sum);
	}
}