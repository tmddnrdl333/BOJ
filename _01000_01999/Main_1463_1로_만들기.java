package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 15,616kb
// 108ms

public class Main_1463_1로_만들기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n < 2 ? 3 : n + 1];
		dp[0] = 0;
		dp[1] = 0;
		dp[2] = 1;
		for (int i = 3; i <= n; i++) {
			int a = i % 3 == 0 ? dp[i / 3] + 1 : Integer.MAX_VALUE;
			int b = i % 2 == 0 ? dp[i / 2] + 1 : Integer.MAX_VALUE;
			int c = dp[i - 1] + 1;
			dp[i] = Math.min(Math.min(a, b), c);
		}
		bw.write(Integer.toString(dp[n]));
		bw.flush();
		bw.close();
	}
}