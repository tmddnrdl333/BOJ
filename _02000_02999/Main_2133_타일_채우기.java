package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 11,584kb
// 76ms

public class Main_2133_타일_채우기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		if (n % 2 != 0) {
			bw.write("0");
			bw.flush();
			bw.close();
			return;
		}
		int[] dp = new int[n + 1];
		dp[0] = 1;
		if (n > 1)
			dp[2] = 3;
		if (n > 3)
			dp[4] = dp[2] * dp[2] + 2; // 11
		for (int i = 6; i <= n; i++) {
			dp[i] = dp[i - 2] * dp[2];
			for (int j = 4; j <= i; j += 2) {
				dp[i] += dp[i - j] * 2;
			}
		}
		bw.write(Integer.toString(dp[n]));
		bw.flush();
		bw.close();
	}
}