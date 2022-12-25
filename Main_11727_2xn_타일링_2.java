package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 11,632kb
// 76ms

public class Main_11727_2xn_타일링_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static final int mod = 10007;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 3];

		dp[1] = 1;
		dp[2] = 3;
		dp[3] = 5;

		for (int i = 4; i <= N; i++)
			dp[i] = (dp[i - 1] + dp[i - 2] * 2) % mod;

		bw.write(dp[N] + "");
		bw.flush();
		bw.close();
	}
}